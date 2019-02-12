package gorm.removefrombag.issue

class Location {

    String name

    Collection<Post> posts = []

    static hasMany = [
            posts: Post
    ]

    static constraints = {
    }

    def afterLoad() {
        sleep(500)
    }
}
