$(document).ready(function(){
    
    $(".close").click(function(){
        $(".row").eq(0).fadeOut("slow");
        $(".row").eq(1).fadeOut("slow");
    })
    
    $("form").submit(function(event){
        if($("#password").val()!=$("#retype-password").val()){
            $(".row").eq(0).fadeIn("slow");
            event.preventDefault();
        }
        
        if($("#password").val().length<=6){
            $(".row").eq(1).fadeIn("slow");
            event.preventDefault();
        }
    });
    
    $("#eye").on({mouseover:function(){
           $("#password").attr("type","text");
       },
   mouseout:function(){
       $("#password").attr("type","password");
   }});
   
    $("#eye1").on({mouseover:function(){
           $("#retype-password").attr("type","text");
       },
   mouseout:function(){
       $("#retype-password").attr("type","password");
   }})
       
});