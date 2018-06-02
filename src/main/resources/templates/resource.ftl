(function(w){
	/**
	 * 工具栏的权限过滤
	 * @param tools
	 * @returns
	 */
	function authToolBar(tools) {
		var toolbars = [];

		$.each(tools, function(key, btn) {

				toolbars.push(btn);
		});
		if(arguments.length > 1){
			for(var i = 1;i < arguments.length; i++){
				toolbars.push(arguments[i])
			}
		}
		return toolbars;
	}
	w.authToolBar = authToolBar;
})(window);