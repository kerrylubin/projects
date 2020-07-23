<?php

$dir_path = "images/gallery/";

    $extensions_array = array('jpg','png','jpeg');
    
    if(is_dir($dir_path))//if there is a directory
    {
        $files = scandir($dir_path);//scan folder to know whats inside

        for($i = 0; $i < count($files); $i++)
        {                  
            if($files[$i] !='.' && $files[$i] !='..')
            {
                // get file name
                //echo "File Name -> $files[$i]<br>";
                // get file extension
                $file = pathinfo($files[$i]);//this gets info like dirname, basename, extension (if any), and filename

                $extension = $file['extension'];
                //echo "File Extension-> $extension<br>";
                //check file extension
                list($width, $height) = getimagesize($dir_path.$files[$i]);
                //this get info on images including dimansions,name etc

                // echo "width: " . $width . "<br />";
                // echo "height: " .  $height;
                // if height is greater than width
                if(in_array($extension, $extensions_array) )
                {
                    echo
                    "<div class='col-lg-3 col-md-6 col-sm-6 gallery-images'>
                    <div class='gallery-grids mb-3'>
                       <figure class='effect-milo'>
                          <img src='$dir_path$files[$i]' alt='' class='img-fluid'>
                          <figcaption>
                             <h5>our<span>Gallery</span></h5>
                             <p>Lorem ipsum dolor</p>
                             <a href='$dir_path$files[$i]' class='gallery-box' data-lightbox='example-set' data-title=''>
                             </a>
                          </figcaption>
                       </figure>
                    </div>
                    <div class='gallery-grids'>
                       <figure class='effect-milo'>
                          <img src='$dir_path$files[$i]' alt='' class='img-fluid'>
                          <figcaption>
                             <h5>our<span>Gallery</span></h5>
                             <p>Lorem ipsum dolor</p>
                             <a href='$dir_path$files[$i]' class='gallery-box' data-lightbox='example-set' data-title=''>
                             </a>
                          </figcaption>
                       </figure>
                    </div>
                 </div>";
                    
                }
                // else if(in_array($extension, $extensions_array) && $width > $height )
                // {
                //     echo 
                //     "<div class='col-lg-8 col-md-8 col-sm-8 gallery-grids'>
                //         <figure class='effect-apollo'>

                //             <img src='$dir_path$files[$i]' style=display:inline;' ><br>

                //             <figcaption>
                //                 <h6>Lua <span>schoonmaak</span></h6>
                //                 <p>Lua aan het Werk</p>

                //                 <a href='$dir_path$files[$i]' class='gallery-box' 
                //                 data-lightbox='example-set' data-title=''></a>
                            
                //             </figcaption>
                //         </figure>
                //     </div>";
                // }

            }
        }

        
        

    }

?>