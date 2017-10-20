$(document).ready(function(){
  
   $("button").click(function(){
      var id = $(this).attr("name");
      $.ajax({
            url: "ItemControl",
            method: "GET",
            data: { action:'updateItemStatus',id : id },

            success: function(){
              location.reload();
        }
  });
   });
    
});