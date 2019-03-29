

var intervalid;
 var number=0;//水量的值，之后将值传入
var waterYield=2000;//定义总水量
var isMouseOver=false;//表示鼠标是否移入


setInterval("test()",500);
function test() {
    $.ajax({
        url: '/water',
        async:true,
        type: 'get',
        success:function (num) {
            intervalcall(num)
        }

    })
}


function intervalcall(num){
    number=num;
    var percect = Math.round(num*100/waterYield*10)/10;

    if(percect>100){
        percect=100;//用于水量超过总水量后，撑面子用
    }

    var mpercent1 = percect>10?(percect-10):percect;
    var mpercent2 = percect>20?(percect-20):percect;

    if(isMouseOver){//根据鼠标是否移入显示数据
        $("#box1").text(Math.round(num*100)/100);
    }else{
        $("#box1").text(percect+"%");/*percect.toString()或者改写法会自动转换为字符串*///(#3D9171    " + mpercent+ "%,#4BCC60 " + percect + "%,#4BCC60)");
    }

    $("#box1").css("background","linear-gradient(#f4f4f4    " + (100-percect)+ "%,#b6e48f " + (100-mpercent1) + "%,#9cd87a " + (100-mpercent2) + "%,#9cd87a)");
    $("#box1").css("background","-webkit-linear-gradient(#f4f4f4    " + (100-percect)+ "%,#b6e48f " + (100-mpercent1) + "%,#9cd87a " + (100-mpercent2) + "%,#9cd87a)");
    $("#box1").css("background","-moz-linear-gradient(#f4f4f4    " + (100-percect)+ "%,#b6e48f " + (100-mpercent1) + "%,#9cd87a " + (100-mpercent2) + "%,#9cd87a)");

    //下列代码用于测试
    //num=num+Math.floor(Math.random()*100);
    //Math.floor(Math.random()*10)//产生随机数用于看带小数的变化
}

function MouseDrag(obj){
    obj.onmousedown=function(ev){
        var down_temp=ev||event;
        var oleft=down_temp.clientX-obj.offsetLeft;
        var otop=down_temp.clientY-obj.offsetTop;

        window.onmousemove=function(ev){
            var move_temp=ev||event;
            var a=move_temp.clientX-oleft;
            var b=move_temp.clientY-otop;

            if(a<0){
                a=0;

            }else if(a>document.documentElement.clientWidth-obj.offsetWidth){
                a=document.documentElement.clientWidth-obj.offsetWidth;

            }

            if(b<56){
                b=56;
            }else if(b>document.documentElement.clientHeight-obj.offsetHeight){
                b=document.documentElement.clientHeight-obj.offsetHeight;
            }

            obj.style.left=a+"px";
            obj.style.top=b+"px";
            return false;
        }

        window.onmouseup=function(ev){
            //²âÊÔÓÃ
            //alert("Left:"+(parseInt(obj.offsetLeft)/parseInt(window.screen.width))*100+"%");
            //alert("Top:"+(parseInt(obj.offsetTop)/parseInt(window.screen.height))*100+"%");
            window.onmousemove=null;
            window.onmouseup=null;
        }
    }
}

$(document).ready(function($) {


    $("#box1").mouseover(function(){
        isMouseOver=true;
        intervalcall(number);
    });

    $("#box1").mouseout(function(){
        isMouseOver=false;
        intervalcall(number);
    })

    MouseDrag(document.getElementById('box1'));
});