//make another shape and make it save
class getExerciseCMS
{
	constructor()
	{
		// console.log(this.COORDINATES);
		this.JSON_DATA =    
    	{
			id: 0,
			exercisetitle: "new exercise",
			language: "nl_NL",
			Application:"oppervlakte_omtrek",
			main_object:
			{
				title: "new exercise",
				language: "nl_NL",
				//coordinates:[],
				exercises: [{
					coordinates:[],
					snap: [],
					degrees:[]
				}]
							
			}
		};
		this.OMTREK;
		this.SOME = new RegExp(/[A-Za-zÀ-ÿ]/g);
		this.SOUND_FILES;
		this.ROUND_OFF = 2;
		this.IMG_FILES;
		this.SELECTED_ID = 0;
    	this.STAGE;
		this.clicks = 0;
		this.NEW;
		this.STAGE_SIZE = 400;
		this.POINT_DRAGGING = false;
		this.DRAGGING = true;
		this.COORDINATES = [];
		this.DEGREES;
		this.SNAP = 10;
		this.GRID_COLOR = '#e5e5e5';
		this.GRID;
		this.EDIT_INDEX = 0;
		this.PNT_COUNT = 0;
		this.ADDING = false;
		this.FILL = 'blue';
		this.LAYER;
		//this.CALC = new calculate();
		this.exercises = this.JSON_DATA.main_object.exercises;
		console.log('JSON_DATA',this.JSON_DATA);
    	this.ID = this.getUrlParameter('id');
		this.LANGUAGE = 'nl_NL';
    	this.TITLE;
    	if (this.ID !== 'new')
    	{
			console.log('NOT NEW PAGE');
            this.readJSONData();
        }
		else 
		{
			console.log('NEW PAGE');
            this.init();
        }
	}

	readJSONData()
	{
		let s = this;
		
		var host = window.location.href.split('\/');
	    var foundID = host.indexOf('applications');
	    var app = '';
	    if(foundID > -1)
	    {
	        app = host[foundID + 1];
	    }

	    var appData = getAppData();
		
		$.post(setJsonApiUrl() + '/api/appexercise/get/' + appData.id, {
	        _: new Date().getTime(),
	        'id': appData.id,
	        'application': appData.app
	    }).done(function(response)
		{
            console.log(response);
            //this is what the FE and BE will use to store the data
            s.JSON_DATA = response.main_object;
            s.LANGUAGE = response.language;
            s.TITLE = response.exercisetitle;
            //data is jsondata
			s.exercises = s.JSON_DATA.exercises;
			//s.COORDINATES = s.exercises[0].coordinates;

			//when data is retrieve from jason it turns into a string
			//This turns the string coords into INT
			//The $.map() method applies a function to each item in an array or object and maps the results into a new array
			$.map(s.exercises[0].coordinates, function(coord, i){
						//coord = cordinates
						//i = current index

						s.COORDINATES[i] = {
							x: parseInt(coord.x),
							y: parseInt(coord.y)
						}
			});
			console.log('Parse',s.COORDINATES);
            $('title').html('CMS ' + s.TITLE);
            $('#title').val(s.TITLE);
            $('#tHead').html(s.TITLE);
            s.getLanguageSelector();
			s.getFileArray();
			s.ready();
        }).fail(
        	function(jqXHR,textStatus,errorThrown)
        	{	
        		console.log(jqXHR);
        		console.log(textStatus);
        		console.log(errorThrown);
        	}
        );
	}

	//init is a functiontion that compute thigs first
	init()
	{

        let s = this;
        s.LANGUAGE = s.JSON_DATA.language;
		s.TITLE = s.JSON_DATA.exercisetitle;
		//this is where this var gets defined
		s.exercises = s.JSON_DATA.main_object.exercises;
		s.COORDINATES = s.exercises[0].coordinates;
		console.log('exercises',s.exercises);
        $('title').html('CMS ' + s.TITLE);
        $('#tHead').html(s.TITLE);
        s.getLanguageSelector();
        s.getFileArray();
        s.ready();
	}

	getFileArray()
	{
		let s = this;
		var request = {language: s.LANGUAGE};
		console.log(request);
		$.ajax(
		{
		    url: "https://media.fcsprint2.nl/api/media/fileList",
		    type: "post",
		    async: true,
		    data: request,
		    dataType: 'json'
		}).done(function(response)
	    {
	        console.log(response);
	        s.SOUND_FILES = response.audio.files;
	        s.IMG_FILES = response.image.files;
	    }).fail(function(jqXHR, textStatus, errorThrown)
	    {
	        console.log(jqXHR);
    		console.log(textStatus);
    		console.log(errorThrown);
	    });
	}
	//this gets the languages from a url
	getLanguageSelector()
	{
		var s = this;
		$.ajax({
	        url: "https://test.diglin.eu/api/languages/unique",
	        type: "post",
	        async: true,
	        dataType: 'json'
		}).done(function(response)
		
	    {
	        var selector = $('#languageSelector');
	        $.each(response,function()
	        {
	            var option = (this.isoCode === s.LANGUAGE) ? $('<option selected></option>').val(this.isoCode).html(this.fullname) : $('<option></option>').val(this.isoCode).html(this.fullname);
	            $(selector).append(option);
	        });

			$(selector).selectpicker();
			console.log('response',response);

	    }).fail(function(jqXHR,textStatus,errorThrown)
	    {
			//have error msg inside
	        console.log(jqXHR);
	        console.log(textStatus);
	        console.log(errorThrown);
	    });
	}

	getUrlParameter(sParam)
	{
        var sPageURL = decodeURIComponent(window.location.search.substring(1)),
            sURLVariables = sPageURL.split('&'),
            sParameterName,
            i;

        for (i = 0; i < sURLVariables.length; i++)
        {
            sParameterName = sURLVariables[i].split('=');
			if (sParameterName[0] === sParam)
            {
                return sParameterName[1] === undefined ? true : sParameterName[1];
            }
        }
    }

	//this function gets the functions inside ready so you can use it
	ready()
	{
		var s = this;
		s.eventFunctions();
		s.fillStages();
		s.getGrid();
		s.buildinputs();
	}

	//build input so you can type in words in a form this has 10 inputs or any amount you want
	buildinputs()
	{
		var s = this;

		console.log('coordinates',s.COORDINATES)
		//s.COORDINATES = s.exercises[0].coordinates;
		s.drawShape(s.COORDINATES);
		
		
		var le = s.exercises.length;
		//console.log(s.exercises);
		if (s.ID === 'new')
    	{
            le = 1;
        }
        else
        {
            le = s.exercises.length;
        }

        
        //this makes a loop for the exercise btn
        for(var i = 0; i < le; i++)
        {
			//if index of the sum is 0 btn will be primary if not default
			var which = (i === 0) ? 'btn-primary' : 'btn-default';
			
        	var btn = $('<button>',
        	{
        		'class': 'btn ' + which + ' choose',
        		'id': 'btn_' + i 
        		//click function to add a stage
        	}).append('exercise ' + (i + 1) );
  			
  			var li = $('<li/>', 
  			{
  				'class':'list-group-item'
  			}).append(btn).appendTo('#list');
        }
	}

	returnArray(ar)
    {
        var ar2 = [];
        for(var i = 0; i < ar.length; i++)
        {
            ar2.push(ar[i].x);
            ar2.push(ar[i].y);
        }
        return ar2;
	}

	//rounds off decimal
	roundOff(n,r)
    {
        var num = n.toString();
        if(num.indexOf('.') > -1)
        {
            if(num.indexOf('.99') > -1)
            {
                return Math.ceil(n).toString();
            }
            else
            {
                var fixed = parseFloat(num).toFixed(r);

                var del = '.';
                for(let i = 0; i < r; i++)
                {
                    del += '0';
                }
                var f2 = fixed.replace(del,'');
                var reg = new RegExp(/(?=.*?\.)(.*?[1-9])(?!.*?\.)(?=0*$)|^.*$/);
                return f2.match(reg)[0];
            } 
        }
        else
        {
            return num;
        }
    }
	
	getPythagoras(hor,ver)
    {
        var s = Math.pow(hor, 2) + Math.pow(ver, 2)
        return Math.sqrt(s);
	}
	
	nxt(index,ar)
    {
        if(index === ar.length - 1)
        {
            return 0;
        }
        else
        {
            return index + 1;
        }
    }

	cornerDirection(cur,betw,deg)
    {
        var dif = cur - betw;
        if(dif < 0)
        {
            return deg;
        }
        else if(dif === 0)
        {
            return 180;
        }
        else if(dif > 0)
        {
            if(dif <= 180)
            {
                return 360 - deg;
            }
            else
            {
                return deg;
            }
        }
    }

	angleInDegrees(ini, end)
    {
        var radian = Math.atan2((end.y - ini.y), (end.x - ini.x));
        return this.mod(radian * 180 / Math.PI + 90, 360);
	}
	
	mod(a, b)
    {
        return a - Math.floor (a / b) * b;
    }

	//this will fill the for every exercise
	//this adds the anchor points for every exercise which is red
	fillStages()
	{
		
		var s = this;
		s.STAGE = new Konva.Stage({
		    container : '#stage',
		    width: s.STAGE_SIZE,
		    height: s.STAGE_SIZE
		});
       
		s.LAYER = new Konva.Layer();

		s.GRID = new Konva.Layer({
			id:'grid',
			x:(s.STAGE_SIZE/2),
			y:(s.STAGE_SIZE/2),
			offset:{
				x:(s.STAGE_SIZE/2),
				y:(s.STAGE_SIZE/2)
			}
		});
			
		s.STAGE.add(s.GRID, s.LAYER);
	}


	//this adds points to the stage
	//this adds the anchor points for every exercise which is red
	addPoints(i,coor)
	{
		var s = this;

		
		//var coords = [];

		coor = s.COORDINATES;
		

		for (var i = 0; i < coor.length; i++)
		{
			var point = new Konva.Circle({
				x: coor[i].x,
				y: coor[i].y,
				radius: 7,
				fill: '#FF0000',
				id: 'point_' + i
			});

			s.LAYER.add(point);

			
			point.on('mousedown', function(e)
			{
				//this is the point
				console.log('mousedown');
				var ID = s.id(e.target.attrs.id);
				console.log('exercises',s.exercises);

				//this stops any more points from being added
					if(ID === 0 && s.PNT_COUNT > 2)
					{
						
						var coor = s.COORDINATES;
						s.drawShape(coor)
						s.ADDING = false;
				
					}

			});

				s.LAYER.draw();
		};
		
	}

	getGrid()
	{
		var s = this;
		//var snap = 10;
		s.LAYER.removeChildren();
		s.GRID.removeChildren();
		//extream is used s as the stagesize width and height (651.4142135623731)
		var stage = s.STAGE_SIZE;//?
		//rest is 650.7071067811866 
		//var rest = (stage + s.STAGE_SIZE)/2;//?
		//space is the numbers of blocks in the grid HOR & VER
		var space = s.STAGE_SIZE/s.SNAP;

		//space is the numbers of blocks in the grid HOR & VER
		var space = s.STAGE_SIZE/s.SNAP;

		var start = Math.ceil(stage/space);
		//var gridLength = s.STAGE_SIZE + (stage - s.STAGE_SIZE);

		for(let i = 0 - start; i < s.SNAP + start; i++)
		{
			var lineVer = new Konva.Line({
				x: 0,
				y: 0,
				points: [Math.round(i * space), 0 - stage, Math.round(i * space), stage],
				stroke: s.GRID_COLOR,
				strokeWidth: 1
			});

			var lineHor = new Konva.Line({
				x: 0,
				y: 0,
				points: [0 - stage, Math.round(i * space), stage, Math.round(i * space)],
				stroke: s.GRID_COLOR,
				strokeWidth: 1
			});

			s.GRID.add(lineVer);
			s.GRID.add(lineHor);
		}

		s.GRID.draw();

	}

	drawShape(i,coor)
	{
		//console.log(i);
		var s = this;

		s.LAYER.removeChildren();
		s.GRID.removeChildren();
		var coor = s.COORDINATES;

		var coords = s.returnArray(coor);

		var line = new Konva.Line({
            points: coords,
            stroke: 'black',
            strokeWidth: 1.5,
            closed: true,
            id: 'line'
        });

        s.LAYER.add(line);

		for (var i = 0; i < coor.length; i++)
		{
		
			//console.log(coor[i]);
			//group for the omtrek
			var group = new Konva.Group
			({
				x: (coor[s.nxt(i,coor)].x - coor[i].x) / 2 + coor[i].x,
				y: (coor[s.nxt(i,coor)].y - coor[i].y) / 2 + coor[i].y,
				id:'group_' + i
			});

			var om = s.getPythagoras(coor[s.nxt(i,coor)].x - coor[i].x, coor[s.nxt(i,coor)].y - coor[i].y) / (s.STAGE_SIZE/s.SNAP);

			s.OMTREK = [s.roundOff(om,2)];

			console.log('Xcoord',coor[s.nxt(i,coor)].x - coor[i].x,'Ycoord',coor[s.nxt(i,coor)].y, coor[i].y);

			//text for the omtrek
	        var txt = new Konva.Text({
				x: 0,
				y: -8,
				text:' ' + s.OMTREK,
				height:14,
				fontSize: 17,
				fontFamily: 'Ubuntu',
				fontStyle:'bold',
				fill: 'white',
				align: 'center',
				id:'info_' + i
			});
			
			var tw = txt.getTextWidth();


			var sideI = new Konva.Rect({
	            x: 0,
				y: -8,
	            width:tw,
	            cornerRadius:3,
	            height:16,
	            fill:'blue'/*s.MODES[s.MEASURES[s.EDIT_INDEX]['sides'][i]]*/,
	            id:'sideI_' + i
	        });

			group.add(sideI);
	        group.add(txt);
	        s.LAYER.add(group);

			var point = new Konva.Circle
			({
				x: coor[i].x,
				y: coor[i].y,
				radius: 7,
				fill: 'blue',
				id: 'point_' + i,
				draggable: s.DRAGGING,
				dragBoundFunc: function(pos)
	            {
					
	            	s.POINT_DRAGGING = true;
					var ID = parseInt(this.attrs.id.split('_')[1]);
					s.pointId = ID;
					console.log(ID);
					//coor[ID] = {x:pos.x,y:pos.y};
					//var degs = s.CALC.calculateCorners(coor);
					
                    var newX = pos.x;
					var newY = pos.y;
					var space = s.SNAP;
					//when the anchors are dragged this will keep it whitin the stage
					//if the position.x is less than SNAP(snap is the amount of boxes in the X and Y)
					//pos.x is newX
					//console.log(s.STAGE_SIZE - s.SNAP);
                    if(pos.x < space)
                    {
                        newX = space;
					}
					//if the pos.x is greater than the stage stage size(400)-SNAP(10) = 390 
				  //(this will make it look like the anchors are within the stage)
					//newX is pos.x
                    if(pos.x > s.STAGE_SIZE - space)
                    {
                        newX = s.STAGE_SIZE - space;
                    }
                    if(pos.y < space)
                    {
                        newY = space;
                    }
                    if(pos.y > s.STAGE_SIZE - space)
                    {
                        newY = s.STAGE_SIZE - space;
                    }
                    
                    // if(s.arrayMin(degs) <= 20)?
                    // {
                    //     overcount++;
                        
                    //     if(overcount === 1)
                    //     {
						//
                            var PO = {x:newX,y:newY};
					//     }
					
						//this move the lines with the anchors when it is dragged
                        coor[ID] = {x:PO.x,y:PO.y};
						s.moveLines(coor,ID,PO);
						
                         // Still not sure but this sets the line coordinates when it is dragged from the anchors?
                        //s.LAYER.get('#line').setPoints(s.CALC.returnArrayPoly(coor));

                        return {
                            x: PO.x,
                            y: PO.y
                        };
                    // }
                    // else
                    // {
                    //     coor[ID] = {x:newX,y:newY};
                    //     s.moveLines(coor,ID,s.EDIT_INDEX,{x:newX,y:newY},s.SNAP);
                    //     overcount = 0;
                    //     return {
                    //         x: newX,
                    //         y: newY
                    //     };
                    // }
	            }
				
			
			});

			s.LAYER.add(point);

			//this is the SNAP fucntion that snaps the anchors to the grid
			// $(document).on('mouseup',function()
	        // {
	        // 	//overcount = 0;
	        // 	if(s.POINT_DRAGGING)
	        // 	{
	        // 		var x = s.LAYER.get('#point' + s.pointId)[0].attrs.x;
	        // 		var y = s.LAYER.get('#point' + s.pointId)[0].attrs.y;
	        // 		var newPosX = Math.round(x / (s.STAGE_SIZE/s.SNAP)) * (s.STAGE_SIZE/s.SNAP);
	        // 		var newPosY = Math.round(y / (s.STAGE_SIZE/s.SNAP)) * (s.STAGE_SIZE/s.SNAP);
			// 		//sets the position of the anchors
			// 		s.LAYER.get('#point' + s.pointId).setX(newPosX);
			// 		s.LAYER.get('#point' + s.pointId).setY(newPosY);
			// 		s.COOR[s.pointId] = {x:newPosX,y:newPosY};
		
	        // 		//s.moveLines(s.COOR,s.pointId,s.EDIT_INDEX,{x:newPosX,y:newPosY},s.SNAP);
	        // 		s.LAYER.draw();
	        // 	}
	        // 	s.POINT_DRAGGING = false;
	        // });	


			point.on('mouseover', function() {
				document.body.style.cursor = 'pointer';
			});
			
			point.on('mouseout', function() {
				document.body.style.cursor = 'default';
			});

			point.on('mousedown', function(e)
			{
				//console.log('MOUSEDOWN', point);
			});

			//  

			
		}

		s.LAYER.draw();
	}


	moveLines(ID,coor,pos)
	{
		var s = this;
		coor = s.COORDINATES;
		//this is to get and set point 
		s.LAYER.get('#line').setPoints(s.returnArray(coor));

		s.LAYER.get('#group_' + ID).setY(0);

		
		console.log(s.OMTREK);

		//for loop is crated to acces each and every index for the omtrek text group
		for(var i = 0; i < coor.length; i++)
		{
			//console.log(i);
			var tPath = s.LAYER.get('#group_' + i)[0].children[1];
			var rPath = s.LAYER.get('#group_' + i)[0].children[0];

			//this is the omtrek berekening
			var om2 = s.getPythagoras(coor[s.nxt(i,coor)].x - coor[i].x,coor[s.nxt(i,coor)].y - coor[i].y) / (s.STAGE_SIZE/s.SNAP);
			s.OMTREK = s.roundOff(om2,s.ROUND_OFF);

			//var omTrk = s.OMTREK;

			tPath.setText(' ' +  s.OMTREK);
			console.log(s.OMTREK);
			var tw2 = tPath.getTextWidth();
			rPath.setWidth(tw2);

			//this moves the omtrek text with the lines
			s.LAYER.get('#group_' + i).setX((coor[s.nxt(i,coor)].x - coor[i].x) / 2 + coor[i].x);
			s.LAYER.get('#group_' + i).setY((coor[s.nxt(i,coor)].y - coor[i].y) / 2 + coor[i].y);


		}


		


	}


	eventFunctions()
	{
		let s = this;

		$(document).on('click', '#point', function()
		{
			s.ADDING = true;
		});


		//this addpoints and start the point count increment
		//can also go in fillstages code block
		$(document).on('mouseup', '#stage', function(e)
		{	
			
			if(s.ADDING)
			{
				s.PNT_COUNT++;
				//var ID = s.SELECTED_ID;
				console.log('point', s.PNT_COUNT);

				//by putting e.offsetX and y to a var it makes is easier to manipulate
				var newPosX = e.offsetX;
				var newPosY = e.offsetY;

				//by putting the var above into an object makes it easier to access the info in the var
				//by just calling the property or key of the var
				s.COORDINATES.push({x:newPosX,y:newPosY});
				var coor = s.COORDINATES;
				console.log('coords', coor);
				s.addPoints(coor);
				
	
			}
			
		});

		$(document).on('change', '#languageSelector', function ()
		{
		    s.JSON_DATA = {
				"id": s.ID,
  				"exercisetitle": s.TITLE,
  				"language": $(this).val(),
  				"Application": "oppervlakte_omtrek",
  				"main_object": {
  					"title": "Kevin",
    				"language": $(this).val()  				}
		    };
		    s.LANGUAGE = s.JSON_DATA.language;
	        s.TITLE = s.JSON_DATA.exercisetitle;
            s.getFileArray();
		});
		//this saves the data from the cms to the JSON_
		$(document).on('click','#btn_save',function()
		{
			//the title  of the page is put into this VAR
			var etitle = (s.SOME.test($('#title').val())) ? $('#title').val() : s.TITLE;

			console.log(s.exercises);
			var JSON_DATA = 
			{
				id: s.ID,
				title: etitle,
				language: s.LANGUAGE,
				application: "oppervlakte_omtrek",
				main_object:
				{
					title: etitle,
					language: s.LANGUAGE,
					//exercises is the var that you store the exercises answers in
					exercises: s.exercises
				}
			};
		
			s.sendData(JSON_DATA);
		});

		//an event listener on a click assign to a btn
		$(document).on('click','#addInput',function()
		{
			console.log(' CLICK')
			 var c = 0;
			//every exercise you make it will push a new object into an array
			//so it can be access 
			s.exercises.push({coordinates:[],snap:[],degrees:[]})
			console.log(s.exercises);

			
			//for each ul id list and li add a button and to c
			$('ul#list>li').each(function(i,ui)
			{
				c++;
				console.log(c);
			});
			
			//make a button with the id num of the exercise
			var btn = $('<button>',
        	{
        		'class': 'btn btn-default choose',
        		'id': 'btn_' + c
			}).append('exercise ' + (c +1));

				
			//this makes the li and ads it to the input element 
			//and then the id of a <div>
			var li = $('<li/>',{
				'class': 'list-group-item'
			}).html(btn);

			$('#list').append(li);
			//s.eventFunctions();
			//s.SELECTED_ID = c;
			
		});

		

		//adding .choose will ad an extra class to the previous class
		$(document).on('click', '.choose', function (e)
		{
			var ID = s.id($(this));
			//var ID = parseInt($(this).attr('id').split('_')[1]);
			var sId = parseInt($(this).attr('id').split('_')[1]);
			console.log('Sum_'+sId,s.exercises);
			
			//what is s.exercises.length exactly?
			for ( var i = 0; i < s.exercises.length; i++)
		 	{
				//console.log('ForLoopID_'+i,'exerciseID_'+ID);
				if(i === ID)
				{
					console.log(ID)
					$('#btn_' + i).removeClass('btn-default').addClass('btn-primary');	
				}
				else
				{
					$('#btn_' + i).removeClass('btn-primary').addClass('btn-default');
				}
			}
			
			

			// $(document).ready(function() {
			// 	$('.myClass').click(function() {
			// 		alert($(.myClass).attr("iditem"));
			// 	});
			// });

			//when data is retrieve from jason it turns into a string
			//This turns the string coords into INT
			//The $.map() method applies a function to each item in an array or object and maps the results into a new array
			$.map(s.exercises[ID].coordinates, function(coord, i)
			{
				s.COORDINATES[i] = {
					x: parseInt(coord.x),
					y: parseInt(coord.y)
				}
			});
			  //console.log(s.COORDINATES);
			  s.drawShape(s.COORDINATES);
		});
	}


	getInputData()
	{
		var s = this;
		var ar = [];
		$('ul#list>li>input').each(function(i,ui)
		{
			var v = $(ui).val();
			if(s.SOME.test(v))
			{
				ar.push(v);
			}
		});
		return ar;
	}

	id(t)
    {
       var ar = ($(t).attr('id') !== undefined) ? $(t).attr('id').split('_') : t.split('_');
       var ar2 = [];
       for(let i = 1; i < ar.length; i++)
       {
           ar2.push(parseInt(ar[i]));
       }
       if(ar2.length < 2)
       {
           return ar2[0];
       }
       else
       {
           return ar2;
       }
    }

	mymax(a)
	{
	    var m = -Infinity, i = 0, n = a.length;

	    for (; i != n; ++i)
	    {
	        if (a[i] > m)
	        {
	            m = a[i];
	        }
	    }

	    return m;
	}

	sendData(exObject)
	{
		let editUrl = '/admin/appexercise/edit';

        $.ajax({
            url: editUrl,
            type: 'post',
            data: {'data': exObject},
            dataType: 'json'
        }).done(function (response)
        {
            window.location.href = './';
        }).fail(function (jqXHR, textStatus, errorThrown)
        {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        });
    }
}