function showUploadedItem (source) {
	var list = document.getElementById("image-list"),
		li   = document.createElement("li"),
		img  = document.createElement("img");
		img.src = source;
		li.appendChild(img);
		list.appendChild(li);
}


(function () {
	  var input = document.getElementById("image"),
	  formdata = false;
	     
	  if (window.FormData) {
	    formdata = new FormData();
	    document.getElementById("btn").style.display = "none";
	  }
	   
	 
	if (input.addEventListener) {
		  input.addEventListener("change", function (evt) {
		    var i = 0, len = this.files.length, img, reader, file;
		    document.getElementById("response").innerHTML = "Uploading . . ."
		    for ( ; i < len; i++ ) {
		      file = this.files[i];
	   
	    		if ( window.FileReader ) {
	    			  reader = new FileReader();
	    			  reader.onloadend = function (e) {
	    				  showUploadedItem(e.target.result);
	    			  };
	    			  reader.readAsDataURL(file);
	    		}
	    		
	    		if (formdata) {
	    		   formdata.append("image", file);

	    		   $.ajax({
						headers: { "Accept" : "application/json; charset=utf-8"},
						type: "POST",
						url: "/ImageUpload/123/saveimage",
						data: formdata,
						processData: false,
	    			    contentType: false,
						dataType: "json",
						beforeSend: function( xhr ) {
							console.log("Making the ajax call");
						},					
						success: function(response){
							console.log("Sucess in ajax call");
							console.log(response);
						},
						error: function(response){
							console.log("Error occured in ajax call");
							console.log(response);
						}
					});
	    		}		    	  
		    }
		       
	  }, false);
	}
}());
	
