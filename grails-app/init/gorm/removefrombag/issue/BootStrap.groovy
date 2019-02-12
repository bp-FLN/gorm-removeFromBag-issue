package gorm.removefrombag.issue

import org.apache.commons.lang.RandomStringUtils

class BootStrap {

    def init = { servletContext ->
        def post = new Post(title: RandomStringUtils.randomAlphanumeric(20))

        10.times {
            post.addToLocations(
                    new Location(name: RandomStringUtils.randomAlphanumeric(20)).save()
            )
            post.addToPublications(
                    new Publication(description: RandomStringUtils.randomAlphanumeric(20)).save()
            )
        }

        post.save()

        3.times {
            new Location(name: it.toString()).save()
            new Publication(description: it.toString()).save()
        }
    }

    def destroy = {
    }
}
