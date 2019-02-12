package gorm.removefrombag.issue

class TestController {

    def index() {
        Location.withTransaction {
            Location.withSession { session ->
                def post = Post.lock(1L)

                3.times {
                    Location location = Location.findByName(it.toString())
                    post.addToLocations(location)
                }

                session.flush()
                session.clear()

                post.refresh()

                def locations = Location.createCriteria().list(max: 2) {}
                locations.each { Location location ->
                    post.removeFromLocations(location)
                }

                session.flush()

                true
            }
        }

        render "Ok"
    }

    def index2() {
        Location.withTransaction {
            Location.withSession { session ->
                def post = Post.lock(1L)

                3.times {
                    Publication publication= Publication.findByDescription(it.toString())
                    post.addToPublications(publication)
                }

                session.flush()
                session.clear()

                post = Post.lock(1L)

                def publications = Publication.createCriteria().list(max: 2) {}
                publications.each { Publication publication ->
                    post.removeFromPublications(publication)
                }

                session.flush()

                true
            }
        }

        render "Ok"
    }
}
