var headers = [$("#best"), $("#free"), $("#cheat")];
var posts = [$("#best_posts"), $("#free_posts"), $("#cheat_posts")];

var temp_header;

$(headers).each(function(index,item){
	
	item.click(function(){
		
		headers[0].attr("class","");
		
		if(temp_header != undefined){
			$(temp_header).attr("class","");
		}
		
		temp_header = item;
		
		item.attr("class","major");
		
		$(posts).each(function(idx,obj){
			obj.css("display","none");
		});
		
		posts[index].show();
	});
});

