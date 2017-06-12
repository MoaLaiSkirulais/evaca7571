applicationContext.getBean('pluginManager').allPlugins.each {plugin ->
    println "${plugin.name} - ${plugin.version}"
}

import evaca.*
def myService = ctx.getBean('pluginManager')

myService.allPlugins.each {plugin ->
	println "${plugin.name} - ${plugin.version}"
}
