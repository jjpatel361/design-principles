class Book {
    def getTitle() {
        return "Kane and Abel"
    }

    def getAuthor() {
        return  "Jeffery Archer"
    }

    def turnPage() {
        println("turning to next page");
    }
}

class BookLocator {
    def getLocation(Book b) {
        println("Finding book..")
    }
}

class Mailer {
    def sendEmail(Book book, String addr) {
        println("Emailing to the $addr")
    }
}