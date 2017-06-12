applicationContext.getBean('pluginManager').allPlugins.each {plugin ->
    println "${plugin.name} - ${plugin.version}"
}
