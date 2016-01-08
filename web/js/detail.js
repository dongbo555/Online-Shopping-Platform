/**
 * Created by 博 on 2016/1/8.
 */
$(function (){
    $(".plus").click(function(){
        var number=parseInt($("#number").val());
        var remainder=parseInt($("#xg").html());
        if(number<remainder){
            number++;
            $("#number").val(number);
        }
    });
    $(".reduction").click(function () {
        var number=$("#number").val();
        if(number>1){
            $("#number").val((number-1));
        }
    });


});


