class HumanWorker{
    def work() {
        println('Human Worker is working...')
    }
}

class RobotWorker{
    def work() {
        println('Robot worker is working 2x faster.')
        println('Robot worker is done with job.!!')
    }
}

class Manager{

    HumanWorker h;

    def assignWorker(HumanWorker worker) {
        h = worker;
    }

    def work(){
        println 'Manager Started working.. '
        h.work();
    }
}

static main(args) {
    HumanWorker h = new HumanWorker();
    Manager m = new Manager();
    m.assignWorker(h);

    m.work();
}