$(document).ready(function(){
  
   $("#eye").on({mouseover:function(){
           $("#password").attr("type","text");
       },
   mouseout:function(){
       $("#password").attr("type","password");
   }});
    
});