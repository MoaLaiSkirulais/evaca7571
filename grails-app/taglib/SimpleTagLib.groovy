class SimpleTagLib {
    def emoticon = { attrs, body ->
       out << body() << (attrs.happy == 'true' ? " :-)" : " :-(")
    }
	
	def dateFormat = { attrs, body ->
		out << new java.text.SimpleDateFormat(attrs.format).format(attrs.date)
	}
	
	def formatBook = { attrs, body ->
		out << "<div id=\"${attrs.book.id}\">"
		out << "Title : ${attrs.book.title}"
		out << "</div>"
	}

}
