$(document).ready(function(){
  
   $("#delete").click(function(){
      var id = $(this).attr("name");
      $.ajax({
            url: "ItemControl",
            method: "GET",
            data: { action:'deleteItemByAdmin',id : id },

            success: function(){
              location.reload();
        }
  });
   });
   
   $("#approve").click(function(){
      var id = $(this).attr("name");
      $.ajax({
            url: "ItemControl",
            method: "GET",
            data: { action:'approveItem',id : id },

            success: function(){
              location.reload();
        }
  });
   });
    
});