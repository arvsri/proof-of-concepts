<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Anucana</title>

<link href="http://localhost:8081/contents/css/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="http://localhost:8081/contents/css/anucana_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://localhost:8081/contents/css/jcrop/jquery.Jcrop.css" type="text/css" />
<link rel="stylesheet" href="http://localhost:8081/contents/css/colorbox.css" />
<link rel="stylesheet" href="http://localhost:8080/ImageUpload/static/style/preloader.css" />

<link rel="stylesheet" href="http://localhost:8081/contents/css/flexslider.css" type="text/css" media="screen" />
<link rel="shortcut icon" href="http://localhost:8081/contents/images/icons/favicon.ico" />
</head>
<body class="fontBlack"> 

<div id="anucana_outer_wrapper">
        <div id="anucana_main">
            <div id="grey_wrapper" class="greyLinen_background">

                <div style="margin-top:10px;">
                
                  <div id="container" style="overflow: hidden; position: relative;">
                
                      <div class="darkShadeOverlay roundedTopCorners" style="height:200px;"></div>
                      <div class="darkShadeOverlay roundedBottomCorners" style="height:50px;margin-top:5px;"></div>
                      
                      <div id="profileBannerBox" class="communityFontsize col4">
                        <table style="width:100%">
                          <tr>
                            <td style="padding : 30px;width:30%">
                              <div id="profilePicBlock">
                                <img id="profilePic" class="profilePicImage" src="${imageUploadResponse.imgURL}" />
                                <a class="inline" id="imageUploader" href="#inline_content">
                                  <img  src="http://localhost:8081/contents/images/edit-pen-icon-white.png" />
                                </a>
                              </div> 
                            </td>
                            <td>
	                          <div style="float:right; padding-right:10px; position: absolute; top: 38px; right: 5px;">
	                            <a href="CommunitySearch.html">Skip this step</a>
	                          </div>
                            </td>
                            
                          </tr>
                        </table>
                      </div>
                  </div>
                </div>
            </div> <!-- end of grey_wrapper -->

        </div> <!-- end of anucana_main -->
    </div> <!-- end of anucana_wrapper -->

  <script language="JavaScript" type="text/javascript" src="http://localhost:8081/contents/js/jquery1.9.1.min.js" ></script>
  <script language="JavaScript" type="text/javascript" src="http://localhost:8081/contents/js/jquery-ui.js"></script>
  <script language="JavaScript" type="text/javascript" src="http://localhost:8081/contents/js/jcrop/jquery.Jcrop.min.js"></script>
  <script language="JavaScript" type="text/javascript" src="http://localhost:8081/contents/js/jquery.colorbox.js"></script>
	
	
  <script type="text/javascript">
  
	  var x = 0;
	  var y = 0;
	  var x2 = 0;
	  var y2 = 0;
	  var h = 0;
	  var w = 0;
  
  $(document).ready(function() {
        $(".inline").colorbox({inline:true});
        
        $(document).on("cbox_cleanup", function(){
          	location.reload();
         });
        
        // html 5 form data 
	  	formdata = false;
        
        <c:choose>
        	<c:when test="${imageUploadResponse.dummy eq true}">
	            $("#cropMe").hide();
        	</c:when>
        	<c:otherwise>
	          	$("#imageDrop").css("display","none");
	          	$("#cropMe").load( function(){
	            	$(".inline").colorbox.resize();
	          	}).attr('src', "${imageUploadResponse.imgURL}");
	          	$("#uploadImageButton").attr("value","Change Image");
        	</c:otherwise>
        </c:choose>
        
        $("#uploadFileInput").change(function() {

        	if (window.FormData) {
    		    formdata = new FormData();
    		}
	       	if(!formdata){
	       		$("#imageUploadError").text("You are using an old browser. Our image upload functionality might not work properly");
	       		return;
	       	}
	       	formdata.append("image", this.files[0]);
	       	
	   	    $.ajax({
				headers: { "Accept" : "application/json; charset=utf-8"},
				type: "POST",
				url: "/ImageUpload/saveimage",
				data: formdata,
				processData: false,
			    contentType: false,
				dataType: "json",

				beforeSend: function( xhr ) {
		          	$("#imageDrop").html('<div>loading ... </div><div class="loader bubblingG"><span id="bubblingG_1"></span><span id="bubblingG_2"></span><span id="bubblingG_3"></span></div>').show();
		          	$("#imageUploadError").text("");
		          	$("#cropMe").hide();
		            $(".inline").colorbox.resize();
				},					
				success: function(response){
					var obj = eval(response);
					
					if(obj.imageuploaderror){
						handleImageUploadError(obj.imageuploaderror);
					}else{
						$("#cropMe").attr("src", obj.imageUploadResponse.imgURL + "?blah=" + Math.random()).show();
						$("#imageDrop").text("Upload image").hide();
						$("#imageUploadError").text("");
			          	
			            $('#cropMe').Jcrop({
			                addClass: 'jcrop-centered', // Adds 'jcrop-centered' css class on the image handled by jcrop. 
			                setSelect: [0, 160, 160, 0], // Sets a default crop selection before user clicks on image.
			                aspectRatio: 1/1,              // Adds an aspect ratio of 1:1 as we want a square selection.
			                onSelect : function(cord){
			                	x = cord.x;
			                	y = cord.y;
			                	x2 = cord.x2;
			                	y2 = cord.y2;
			                	w = cord.w;
			                	h = cord.h;
			                }
			            });
			            
			            $("#uploadImageButton").attr("value","Change Image");
			            $("#cropButton").show();
			            $(".inline").colorbox.resize();		            
					}
				},
				error: function(response){
					handleImageUploadError("Error occurred while uploading the image.");
				}
			});
        });
        
   	 	$("#cropButton").on("click",function(){
   	 		var cropCords = "x="+x+"&y="+y+"&x2="+x2+"&y2="+y2+"&h="+h+"&w="+w;
	   	    $.ajax({
				headers: { "Accept" : "application/json; charset=utf-8"},
				type: "POST",
				url: "/ImageUpload/cropImage",
				data:  cropCords,
				processData: false,
				dataType: "json",

				success: function(response){
					var obj = eval(response);
					
					if(obj.imageuploaderror){
						$("#imageUploadError").text(obj.imageuploaderror);
					}else{
						location.reload();
					}
				},
				error: function(response){
					handleImageUploadError("Error occurred while uploading the image.");
				}
			});
   	 		
   	 	});

        
   	    function handleImageUploadError(errorMessage){
   	    	
   	      	$("#imageDrop").text("Upload image").show();
   	      	$("#cropMe").hide();
   	      	$("#imageUploadError").text(errorMessage);
   	      	
   	        $(".inline").colorbox.resize();		            
   	    }

	});
  
  
  </script>
  <!-- This contains the hidden content for modal window -->
  <div style="display:none">
    <div id="inline_content" class="lightBox">
      	<div class="centered">
        	<span id="imageUploadError" style="color:red;font-weight: bold;font-family: sans-serif; font-size: 16px;"></span>
      	</div>
    
      	<div class="crop-image-wrapper">
        	<img id="cropMe" src="" style="width:400px; margin:50px;" />
    		<button id="imageDrop" onclick="document.getElementById('uploadFileInput').click()" title="Click Here">Upload image</button>    	
      	</div>
    
      	<div class="centered">
        	<h4>Select a portion of image above and save it as Profile picture</h4>
      	</div>
      
       	<div id="bottomBar"  class="centered">
       		<input id="uploadFileInput" type="file" name="datafile" size="40" />
       		<input type="button" value="Upload Image" id="uploadImageButton" class="blueButton smallButton" tabindex="1" onclick="document.getElementById('uploadFileInput').click()" />
       		<input id="cropButton" type="button" value="Save Image" style="display:none;" class="blueButton smallButton hidden" ></input>
      	</div>
	  </div>
 	</div>

</body>
</html>
