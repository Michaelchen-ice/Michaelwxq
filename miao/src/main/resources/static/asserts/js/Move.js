		function getStyle(obj,Name){
			if(obj.currentStyle){
				return obj.currentStyle[Name];
			}else{
				return getComputedStyle(obj,null)[Name];
			}
		}

		var timer0;
		var timer1;
		var timer2;
		var timer3;
		var timer4;
		var line={0:timer0,1:timer1,2:timer2,3:timer3,4:timer4};

		function myMove(obj,json,number,endf){
			var cur;
			clearInterval(line[number]);
			line[number]=setInterval(function(){
				var flag=1;
				for(var i in json){
					if(i!='opacity'){
						cur=parseInt(getStyle(obj,i));
						var num=parseInt(json[i]);
						var speed=(parseInt(json[i])-cur)/6;
						if(speed>0){
							speed= Math.ceil(speed); 
						}else{
							speed= Math.floor(speed); 
						}
						obj.style[i]=cur+speed;
						if(obj.style[i]==num+'px'&&flag){
							flag=1;
						}else{
							flag=0;
						}
					}else{
						cur=parseFloat(getStyle(obj,i));
						var num=parseFloat(json[i]);
						var speed=parseFloat(json[i])-cur;
						if(speed>0){
							speed=Math.ceil((parseFloat(json[i])-cur)*100)/500;
						}else{
							speed=Math.floor((parseFloat(json[i])-cur)*100)/500;//目标透明度-当前透明度，保证精确性
						}
						obj.style[i]=cur+speed;//对象.style['属性名']
						if(Math.abs(parseInt((obj.style[i]-num)*10000))<10&&flag){
							flag=1;
						}else{
							flag=0;
						}
					}
				}
				if(flag){
					clearInterval(line[number]);
					if(endf){
						endf();
					}
				}
			},30)
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
					}else if(a>window.screen.width-obj.offsetWidth){
						a=window.screen.width-obj.offsetWidth;
					}
					if(b<0){
						b=0;
					}else if(b>window.screen.height-obj.offsetHeight){
						b=window.screen.height-obj.offsetHeight;
					}
					obj.style.left=a+"px";
					obj.style.top=b+"px";
					return false;
				}

				window.onmouseup=function(ev){
					//测试用
					//alert("Left:"+(parseInt(obj.offsetLeft)/parseInt(window.screen.width))*100+"%");
					//alert("Top:"+(parseInt(obj.offsetTop)/parseInt(window.screen.height))*100+"%");
					window.onmousemove=null;
					window.onmouseup=null;
				}
			}
		}

		function MouseFollow(obj){
			document.onmousemove=function(ev){
				var follow=ev||event;
				var scroll_top=document.documentElement.scrollTop||document.body.scrollTop;
				var scroll_left=document.documentElement.scrollLeft||document.body.scrollLeft;
				obj.style.left=follow.clientX+scroll_left+7;
				obj.style.top=follow.clientY+scroll_top+7;
			}
		}

		function Floater(obj,top_num){
			obj.style.right=0;
			var scroll_top=0;
			if(!isNaN(top_num)){
				scroll_top=document.documentElement.scrollTop||document.body.scrollTop;
				myMove(obj,{top:top_num+scroll_top});
				window.onscroll=function(){
					scroll_top=document.documentElement.scrollTop||document.body.scrollTop;
					myMove(obj,{top:top_num+scroll_top});
				}
			}else{
				scroll_top=document.documentElement.scrollTop||document.body.scrollTop;
				myMove(obj,{top:(window.screen.height-obj.offsetHeight)/2+scroll_top});
				window.onscroll=function(){
					scroll_top=document.documentElement.scrollTop||document.body.scrollTop;
					myMove(obj,{top:(window.screen.height-obj.offsetHeight)/2+scroll_top});
				}
			}
		}