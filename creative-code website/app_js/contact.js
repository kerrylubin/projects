class getContact
{
	constructor()
	{       
        
        this.OFF_DAYS = [];
        this.DISABLED_DAYS = ['01-01','19-04','20-04','21-04', '22-04','27-04','25-12','26-12'];
        this.ALLOWED_TIMES = [ '10:00:00','11:00:00', '12:00:00', '13:00:00','14:00:00', '15:00:00', '16:00:00', '17:00:00', '18:00:00'];
        this.JSON_DATA;
        this.BOOL = false;
        this.DATABASE_DATES_TIMES;
        this.TIME = [];
        this.DATE = [];
        this.getJson();
    }

    getJson()
    {
        var s = this;

        $.post('app_php/data.php').done(function(date)
        {
            // console.log(date );

            s.DATABASE_DATES_TIMES = (date != 'No Data') ? s.DATABASE_DATES_TIMES = JSON.parse(date) :  s.DATABASE_DATES_TIMES = [];
            //console.log('dataBase_D_T  ',s.DATABASE_DATES_TIMES);
           // console.log('dataBase',s.JSON_DATA);
            s.ready();
        }).fail(function(jqXHR,textStatus,errorThrown)
        {
            alert(textStatus + " in JsonData: " + errorThrown + " " + jqXHR);	
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        });

    }
    
    ready()
    {
        var s = this;
        s.datePicker();
        s.events();
    }


    datePicker()
    {
        var offDays = this.OFF_DAYS;
        var disableDays = this.DISABLED_DAYS;//this is also hilidays to disable
        var dataBase_Dates_Times = this.DATABASE_DATES_TIMES;
        var allowedTimes = this.ALLOWED_TIMES;
        var isSet = this.BOOL;

        var dataBase_Dates = []; // better to define using [] instead of new Array();
        var database_Times = [];

        for (var i = 0; i < dataBase_Dates_Times.length; i++) 
        {
            var split = dataBase_Dates_Times[i].split(" ");  // just split once
            dataBase_Dates.push(split[0]); // before the space
            database_Times.push(split[1]); // after the space

        }//this splits the space between the the date and time
        
        //console.log('Dates_Times in DataBase: ',dataBase_Dates_Times);
        // console.log('Time in Data Base: ',database_Times);
        // console.log("Dates in  Data Base: ", dataBase_Dates);

        //this function disables weekends and chosen dates (day != 0 && day != 6) = sat(6) and sun(0) off 
        function SundaysOrHolidaysOff(date) 
        {
            var day = date.getDay();
            //this for weekends sat and sun
            if (day != 0 && day != 6) 
            {
                var d = ("0" + (date.getDate()) ).slice(-2);//having the date numbers like this is better when you want a (0)in it
                var m = ("0" + (date.getMonth()+1 ) ).slice(-2);
                var y = date.getFullYear();

                var xdsoftDate = (y) + '-' + (m) + '-' + (d);//dates in the date time Picker
                
                let result = dataBase_Dates_Times.filter(x => x.includes(xdsoftDate));
                //this checks if the data base has any dates from the month or xdsoftDate and filter all of them out even duplicates
                // and then returns an array with those dates
                //console.log(result)

                if(result.length > 8)
                {
                    // console.log('result length: ',result.length)
                    // console.log('result',result);
                    return [false];
                }//this block dates that are in the DB more than 8x

                 for (var i = 0; i < offDays.length; i++) 
                {
                    //console.log('inArray',$.inArray( xdsoftDate, disableDays));
                    if($.inArray((d) + '-' + (m) +  '-' + (y) , offDays) != -1) 
                    {
                        //console.log('Disabled Days:  ' + (d) + '-' + (m) + '-' + (y) + '  ' + disableDays[i]);
                        return [false];
                    }//this blocks days you want off
                }

                for (var i = 0; i < disableDays.length; i++) 
                {
                    //console.log('inArray',$.inArray( xdsoftDate, disableDays));
                    if($.inArray((d) + '-' + (m) , disableDays) != -1) 
                    {
                        //console.log('Disabled Days:  ' + (d) + '-' + (m) + '-' + (y) + '  ' + disableDays[i]);
                        return [false];
                    }//this blocks holidays and chosen dates for all years

                }
            return [true];
            } 
            else 
            {
                return [false];//this disables all weekends ezer to choose one weekends
            }

           
        }//end of function

        function removeFromArray(original, remove) 
        {
            return original.filter(value => !remove.includes(value));
        }//this removes multiple elements from an array and return a new array

        function checkForDateTime(ct)
        {
            var currentTime = $.datepicker.formatDate('yy-mm-dd', ct);
            var datePicked = currentTime;
   
            var notAllowed = [];

            //loop through the datePicker time to get the Index
            for(var idx = 0; idx < allowedTimes.length; idx++)
            {
                // #3 you need to know if the date you picked is in the data base
                // loop trough the data base to get the dates
                for (var i = 0; i < dataBase_Dates_Times.length; i++) 
                {
                    
                    // if the date and time you picked is in the data base disable that time
                    if( datePicked + ' ' + (allowedTimes[idx]) == dataBase_Dates_Times[i])
                    {
                        //console.log('times to remove',allowedTimes[idx])
                        notAllowed.push(allowedTimes[idx]);
                        //push the times that are in the data base to an array
                    }
                    
                }
            }
            
            //console.log('times to delete: ',notAllowed);
            var newTimes = removeFromArray(allowedTimes,notAllowed);
            //console.log('filtered array: ',newTimes);

            $('#date_picker').datetimepicker('setOptions', {allowTimes:newTimes});
        }
        
        $( "#date_picker" ).datetimepicker(({
            format:'Y-m-d H:i',
            timepicker:true,
            allowTimes: this.ALLOWED_TIMES,
            onGenerate:function( ct, $i )
            {
                //var weekendDay = $.datepicker.formatDate('yy-mm-dd', ct).split('-')[2];
                var weekendDay = $.datepicker.formatDate('yy-mm-dd', ct);
                //var disabledDates = $('.false');
                var weekEnds = $('.false');
                //console.log(weekendDay);
                //console.log("weekendDay" ,weekendDay);
                //console.log($('.true'));

                for (var i = 0;i < weekEnds.length; i++)
                {
                    var d = ("0" + (weekEnds[i].dataset.date)).slice(-2);
                    //var m = $.datepicker.formatDate('mm', ct)
                    var m = ( "0" + (parseInt(weekEnds[i].dataset.month) +1) ).slice(-2);
                    //to do addition in string you will need to parseInt if the number is a string
                    var y = ( weekEnds[i].dataset.year );

                    if(weekendDay ==  (y) + "-" + (m) + "-" + (d) )
                    {
                        //console.log('disable Time');
                        $('.xdsoft_time_variant .xdsoft_time').addClass('xdsoft_disabled');
                    }
                }
               
                if(isSet == false)
                {
                    isSet = true;
                    //console.log(isSet);
                    checkForDateTime(ct);
                }//this if statement prevents the nested loop issue

                //$(this).find('.xdsoft_date.xdsoft_weekend').addClass('xdsoft_disabled');//disable all weekends
                //$('.xdsoft_time').eq(idx).addClass('xdsoft_disabled');
                // the eq works best cause you are selecting the true DOM-element within the jQuery-object
                //$('.xdsoft_time').eq(idx).hide();
              },
              onChangeDateTime:function(ct,$i)
              {
                //console.log('spit: ',$i.val().split(' ')[0]);
                //var dt = $('#date_picker').datetimepicker('getValue');
                //ct = $.datepicker.formatDate('yy-mm-dd', ct);
                //console.log($('.xdsoft_date'));
                checkForDateTime(ct);
              },
            formatDate:'d.m.Y',
            beforeShowDay:SundaysOrHolidaysOff
        }));
    }

    events()
    {
        $(function () {
            // Slideshow 4
            $("#slider4").responsiveSlides({
                auto: true,
                pager:false,
                nav:true ,
                speed: 900,
                namespace: "callbacks",
                before: function () {
                    $('.events').append("<li>before event fired.</li>");
                },
                after: function () {
                    $('.events').append("<li>after event fired.</li>");
                }
            });
        
        });// responsiveslides banner

        (function($){
            // Menu Functions
            $(document).ready(function(){
            $('#menuToggle').click(function(e){
                var $parent = $(this).parent('.menu');
              $parent.toggleClass("open");
              var navState = $parent.hasClass('open') ? "hide" : "show";
              $(this).attr("title", navState + " navigation");
                    // Set the timeout to the animation length in the CSS.
                    setTimeout(function(){
                        console.log("timeout set");
                        $('#menuToggle > span').toggleClass("navClosed").toggleClass("navOpen");
                    }, 200);
                e.preventDefault();
            });
          });
        })(jQuery);//navbar

        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({
                    scrollTop: $(this.hash).offset().top
                }, 900);
            });
        });//start-smoth-scrolling

        $(document).ready(function () {
         
            var defaults = {
                containerID: 'toTop', // fading element id
                containerHoverID: 'toTopHover', // fading element hover id
                scrollSpeed: 1200,
                easingType: 'linear'
            };
        
        
            $().UItoTop({
                easingType: 'easeOutQuart'
            });
        
        });//here stars scrolling icon
    }
}      
