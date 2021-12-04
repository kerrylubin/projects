class getExercise
{
	constructor()
	{
		this.SOUND_FILES;
    	this.IMG_FILES;
    	this.JSON_DATA;
        this.SUMS;
    	this.ID;
    	this.LANGUAGE;
        this.getJsonData();
        console.log(getJsonData());
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

    getJsonData()
    {
    	var s = this;
        s.ID = s.getUrlParameter('id');

    	//$('#place_spinner').prepend(s.spinnerIcon);
        var host = window.location.href.split('\/');
        var foundID = host.indexOf('applications');
        var appData = getAppData();
    	$.post(setJsonApiUrl() + '/api/appexercise/get/' + appData.id, {
            _: new Date().getTime(),
            'id':  appData.id,
            'application':  appData.app
        }).done(function(response)
        {
            s.JSON_DATA = response.main_object;
            s.SUMS = s.JSON_DATA.exercises;
            console.log(s.SUMS);
	        s.LANGUAGE = response.language;
	        s.TITLE = response.exercisetitle;
            
	        $('#title').html(s.TITLE);
	        $('title').html(s.TITLE);
	        $('#tHead').html(s.TITLE);
            
	        s.ready();
            TR.setTracker(response); 
        }).fail(function(jqXHR, textStatus, errorThrown)
        {
            console.log('er is een fout opgetreden');
            console.log(jqXHR);
    	    console.log(textStatus);
    	    console.log(errorThrown);
        }).always(function()
        {
            //$('.outerSpinner').remove();
        });
    }

    ready()
    {
        var s = this;
        s.eventFunctions();
        s.setSums();
    }

    setSums()
    {
        var s = this;
        for ( var i = 0; i < s.SUMS.length; i++)
        {
            var div = $('<div/>').append(s.SUMS[i]).appendTo('#list');
        }
    }

   


	eventFunctions()
	{
		var s = this;
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
}