/*
 * FC-Sprint2 project => index.js
 *
 * The project "diglin.eu" is property of FC-Sprint2
 *
 * Created at:
 * 22-mei-2017 @ 13:24:42
 *
 * Created by:
 * Andries van Weeren
 * a.weeren@fcroc.nl
 */

$(document).ready(function()
{
    var urlArray = window.location.href.split('/');
    var appId = urlArray.indexOf('applications') + 1
    var app = urlArray[appId];

    var table = $('.setdatatbl').DataTable({
        "ajax": {
            url: '/api/appexercise/getall',
            type: 'post',
            data: {'request': app}
        },
        "columnDefs": [
            {type: 'natural', targets: [0, 1]},
            {
                targets: 0,
                data: 'id'
            },
            {
                targets: 1,
                data: 'title',
                render: function (data, type, full, meta) {
                    //console.log(full)
                    full['exercisetitle'] = (full.exercisetitle !== '') ? full.exercisetitle : '<em>[NO TITLE SET]</em>';
                    return '<a href="exercise.php?id=' + full.id +'" class="">' + full.exercisetitle + '</a>';
                }
            },
            {
                targets: 2,
                data: 'language'
            },
            {
                targets: -1,
                data: null,
                searchable: false,
                className: 'text-right',
                render: function (data, type, full, meta) {
                    return '<div class="btn-group">\
                                <a href="cms_exercise.php?id=' + full.id + '" class="btn btn-warning"><i class="fa fa-edit"></i></a>\
                                <a class="btn btn-danger remove" data-id="' + full.id + '"><i class="fa fa-trash"></i></a>\
                                </div>';
                }
            }
        ],
        "pageLength": 25,
        "order": [[0, "desc"]]
    });
    table.on('init.dt', function () {
        setTimeout(function () {
            $(table).css({'width': '100%'});

        }, 500);
    });

    $(document).on('click', '.resethFilter', function () {
        //Reseting all filters (search and column-filters
        table.search('').columns().search('').draw();
        $('input[type="search"]').val('');
        $('.searchbox').val('');
    });
    $(document).on('click', '.newExercise', function () {
        window.location = './cms_exercise.php?id=new';
    });
    $(document).on('click', '.remove', function () {
        var removeId = $(this).data('id');
        var removeEx = confirm('Are you sure');
        if (removeEx === true) {
            var removeUrl = '/admin/appexercise/remove/' + removeId;
            //'del_exercise.php'
            $.ajax({
                url: removeUrl,
                type: 'post',
                data: {id: $(this).data('id')},
                dataType: 'json'
            }).done(function (response) {
                console.log(response);

                var message = response.message.replace('[id]', response.id).replace('[title]', response.title);

                var messageDiv = $('<div></div>').addClass('alert alert-danger').css({'position': 'fixed', 'top': '10px', 'right': '10px'}).html(message);
                $('body').append(messageDiv);
                setTimeout(function () {
                    $('div.alert-danger').remove();
                }, 5000);

                table.ajax.reload(null, false);
            }).fail(function (response) {
                console.log('Remove not succeeded');
            });
        }
    });

});