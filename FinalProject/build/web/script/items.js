$(document).ready(function(){
  
   $("button").click(function(){
      var id = $(this).attr("name");
      $.ajax({
            url: "ItemControl",
            method: "GET",
            data: { action:'deleteItem',id : id },

            success: function(){
              location.reload();
        }
  });
   });
    
});