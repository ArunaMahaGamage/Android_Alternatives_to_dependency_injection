# Alternatives to dependency injection

An alternative to dependency injection is using a service locator. The service locator design pattern also improves decoupling of classes from concrete dependencies. You create a class known as the service locator that creates and stores dependencies and then provides those dependencies on demand.


    class ServiceLocator {

        private static ServiceLocator instance = null;

        private ServiceLocator() {}

        public static ServiceLocator getInstance() {
            if (instance == null) {
                synchronized(ServiceLocator.class) {
                    instance = new ServiceLocator();
                }
            }
            return instance;
        }

        public Engine getEngine() {
            return new Engine();
        }
    }

    class Car {

        private Engine engine = ServiceLocator.getInstance().getEngine();

        public void start() {
            engine.start();
        }
    }

    class MyApp {
        public static void main(String[] args) {
            Car car = new Car();
            car.start();
        }
    }


The service locator pattern is different from dependency injection in the way the elements are consumed. With the service locator pattern, classes have control and ask for objects to be injected; with dependency injection, the app has control and proactively injects the required objects.

Compared to dependency injection:

The collection of dependencies required by a service locator makes code harder to test because all the tests have to interact with the same global service locator.

Dependencies are encoded in the class implementation, not in the API surface. As a result, it's harder to know what a class needs from the outside. As a result, changes to Car or the dependencies available in the service locator might result in runtime or test failures by causing references to fail.

Managing lifetimes of objects is more difficult if you want to scope to anything other than the lifetime of the entire app.
