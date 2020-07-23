<?php
//this is great to do because you can change everything in the website in here without going trough each page

    class contact
    {
        function contact()
        {
            $this->contact_Title ='Contact Us';
            $this->contact_txt ='Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed<br>tempor incididunt ut labore et';

            $this->address = 'kraneweg 74, 9718JV Groningen.';
            $this->address_title = 'Address';

            $this->phone_title = 'Phone';
            $this->email_title ='Email';

            $this->email ='mailto:creativecode.93@gmail.com';
            $this->email_Name ='creativecode.93@gmail.com';


            $this->phone = '(+31) 655515269';
            $this->contact_txt = 'Contact us and make an appointment';

        }
    }

    class common
    {
        function common()
        {
            $this->web_Name = '<font color="#ff3d00">creative</font><font color="#fff">Code</font>';
            $this->webName_logo = '<font color="#ff3d00">creative</font><font color="#000">Code</font>';

            $this->web_Title = 'creativeCode | Home';
            $this->about_us = 'I am commited to satisfy our customers <br> no matter how nasty you dirty house is.';
            $this->story_txt = 'The passion to create is what drives me to code different projects.';

            $this->location = '<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2389.
                0598975381054!2d6.5475243158335905!3d53.216774379952106!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.
                1!3m3!1m2!1s0x47c9cd498dce5477%3A0x3f958ab74d4cda01!2sKraneweg%2074%2C%209718%20JV%20Groningen
                !5e0!3m2!1sen!2snl!4v1572212873159!5m2!1sen!2snl"></iframe>';

        }
    }

    class index
    {
        function index()
        {
            $this->slider_1 ='Creativity <br> 
            and Code';
            $this->slider_1_txt = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do tempor incididunt ut labore et';

            $this->slider_2 ='Clean Work <br> 
            and Maintenance ';
            $this->slider_2_txt = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do tempor incididunt ut labore et';

            $this->slider_3 ='Colorfull <br> 
            and Interactive Design';
            $this->slider_3_txt = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do tempor incididunt ut labore et';


        }
    }

    class about
    {
        function about()
        {
            $this->about_1 = 'What i do';
            $this->about_1_txt = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit,sed do eiusmod tempor incididunt ';

            $this->about_2 = 'Who am I';
            $this->about_2_txt = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit,sed do eiusmod tempor incididunt ';
        }
    }

    class services
    {
        function services()
        {
            $this->service = 'My Services';
            $this->service_txt = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed<br>tempor incididunt ut labore et';

            $this->service_1 = 'Development';
            $this->service_1_txt = 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit';

            $this->service_2 = 'Maintenance';
            $this->service_2_txt = 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit';

            $this->service_3 = 'Clean Work';
            $this->service_3_txt = 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit';

            $this->service_4 = 'Colorfull';
            $this->service_4_txt = 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit';

            $this->service_5 = 'Modern Desgin';
            $this->service_5_txt = 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit';

            $this->service_6 = 'Interactive Desgin';
            $this->service_6_txt = 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit';

        }
    }

    class gallery
    {
        function gallery()
        {
            $this->gallery_title = 'Gallery of Projects';
            $this->gallery_txt = 'Happy customer';
            $this->gallery_img_txt = 'Happy customer';


            $this->about = 'Wat we kunnen doen';
            $this->about_Us = 'We zijn de beste PERIOD.';
        }
    }

    class testimonials
    {
        function testimonials()
        {
            $this->testimonials_title = 'My Clients';
            $this->testimonials_txt = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed<br>tempor incididunt ut labore et';
        }
    }
    
?>