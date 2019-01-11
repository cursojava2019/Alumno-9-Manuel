$(document).ready(function(){
	$(document).ready(function(){
        $("#boton1").click(function(){
        	
        	 $('body').prepend( "<ul id='slideshow2'>" );
        	 $('#slideshow').appendTo('#slideshow2');
        });
    });
  
  
  $(document).ready(function(){
      $("#boton2").click(function(){
    	      var $p=$("#slideshow > li");
    	      var tamano=$p.length;
    	      $p.hide();
            
    	      $p.first();
    	      var cont=0;
              setInterval(function(){
            	  $p.eq(cont).fadeIn(1000);
            	  $p.eq(cont).fadeOut(1000);
            	  cont++;
            	  if(cont>=tamano){
            		  cont=0;
            	  }
              }, 2000);
      });
  });
});