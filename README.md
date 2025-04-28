# Spring DI Demo Application

A simple Spring Boot project demonstrating the basics of **Dependency Injection (DI)** using `Person` and `Pet` (`Cat` and `Dog`) examples.

---

## 🚀 Application Basics

This demo application covers:

- What Dependency Injection is and why it's useful.
- How to implement Dependency Injection using Spring Boot.
- How to dynamically choose between multiple implementations (`Cat` and `Dog`) of the same interface (`Pet`).

---

## ⚙️ How to Run

Ensure you have Java 17+ and Maven installed.

1. **Clone the repository**:
```shell
git clone <your-repo-url>
cd spring-di-demo
```

2. **Run the application** (default `main` branch):
```shell
./mvnw spring-boot:run
```

---

## 🐶 Additional Pet Implementation (`Dog`)

The default (`main`) branch has only the `Cat` implementation. To see an additional pet implementation (`Dog`) and how Spring handles multiple implementations, checkout the branch `additional-pet-dog`:

```shell
git checkout additional-pet-dog
```

On this branch, Spring Boot may raise an error at startup:

```
Field pet in com.neueda.spring_di_demo.Person required a single bean, but 2 were found:
	- cat: defined in file...
	- dog: defined in file...
```

This happens because Spring Boot cannot determine automatically which `Pet` implementation to inject since it has found two candidates (`Cat` and `Dog`).

### 🎯 How to Resolve the Issue

Use `@Qualifier` to specify exactly which implementation to inject:

```java
@Component
public class Person {

    private final Pet pet;

    public Person(@Qualifier("dog") Pet pet) {
        this.pet = pet;
    }

    public void feedPet() {
        pet.feed();
    }
}
```

Now, Spring knows explicitly which `Pet` implementation to inject (`dog`).

---

## 🛠️ Dynamic Pet Selection Service

To dynamically select and inject a pet based on runtime input, checkout the branch `added-pet-service-when-determining-pets`:

```shell
git checkout added-pet-service-when-determining-pets
```

### 🚀 How to Run with Arguments

Run the Spring Boot Application with arguments using Maven:

```shell
./mvnw spring-boot:run -Dspring-boot.run.arguments=dog
```

Expected output:

```
Person is feeding the pet:
Feeding the dog 🐶
```

Change the argument to "cat":

```shell
./mvnw spring-boot:run -Dspring-boot.run.arguments=cat
```

Expected output:

```
Person is feeding the pet:
Feeding the cat 🐱
```

---

## ✅ Verifying Your Setup

After applying `@Qualifier`, run the application again:

```shell
./mvnw spring-boot:run
```

### Expected Console Output

```
Feeding the dog 🐶
```

You can switch between pets by changing the qualifier:

```java
@Qualifier("cat") // or "dog"
```

---

Enjoy exploring Dependency Injection with Spring Boot!