interface Worker {
    def work()
} 


class HumanWorker implements Worker{
    def work() {
        println('Human Worker is working..')        
    }
}

class RobotWorker implements Worker{
    def work() {
        println('Robot worker has finished the task')
    }
}

class Manager{
    Worker w;

    def setWorker(Worker newWorker) {
        w = newWorker
    }

    def work() {
        println('Assigned task to worker...')
        w.work()
    }
}


static main(args) {
    RobotWorker r = new RobotWorker();
    HumanWorker h = new HumanWorker();
    Manager m = new Manager();
    m.setWorker(h);
    m.work();

    m.setWorker(r);
    m.work();

}