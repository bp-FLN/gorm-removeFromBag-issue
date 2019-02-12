package gorm.removefrombag.issue

class Publication {

    String description

    static belongsTo = [post: Post]

    static constraints = {
        post nullable: true
    }

    def afterLoad() {
        sleep(500)
    }
}
