package gorm.removefrombag.issue

class Post {

    String title

    Collection<Location> locations = []
    Collection<Publication> publications = []

    static hasMany = [
            locations   : Location,
            publications: Publication
    ]

    static belongsTo = [Location]

    static constraints = {
    }
}
