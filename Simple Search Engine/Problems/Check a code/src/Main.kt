

class Event(val id: Int, val x: Int, val y: Int, val isLongClick: Boolean) {
    operator fun component1() : Int = id
    operator fun component2() : Int = x
    operator fun component3() : Int = y
    operator fun component4() : Boolean = isLongClick

}

//fun isEventLongClicked(events: Array<Event>, eventId: Int): Boolean? {
//    for ((id, x, y, isLongClick) in events) {
//        if ( id == eventId) return isLongClick
//    }
//    return null
//}
data class Event(val id: Int, val x: Int, val y: Int, val isLongClick: Boolean)

fun isEventLongClicked(events: Array<Event>, eventId: Int): Boolean? {
    for ((id, _, _, isLongClick) in events) {
        if (id == eventId) return isLongClick
    }
    return null
}

//fun main(){
//    val anonim = Event(1, 999, 2,false)
//    val arr = arrayOf<Event>(anonim)
//    val a = isEventLongClicked(arr, 1)
//    print(a)
//}

//class Article(val name: String, val pages: Int, val author: String)
//{
//    operator fun component1(): String = name
//    operator fun component2(): Int = pages
//    operator fun component3(): String = author
//}
//
//fun getArticleByName(articles: Array<Article>, name: String): Article? {
//    var index = -1
//    for ((title, pages, author) in articles) {
//        index += 1
//        if (title == name) return articles[index]
//    }
//    return null
//}
