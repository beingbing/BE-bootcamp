when working on a big project we organise files into multiple folders.

in java to work through this we have concept of Package.

to make object of classes which are not in same Package, we need to import them.

*: wildcard imports will import all the classes of that package.

# polymorphism: having multiple forms
it originates from the idea that there are -
- super type (animal)
- sub type (cow, goat, lion)

> *sub 'is a' super* relation always holds true but reverse will not hold true

** a pointer of super-class can point to an object of subclass but that pointer wouldn't be able to access properties specific to subclass **

when a subclass extends a super-class, all the properties of super-class starts making sense for subclass as well and we regard this characteristic as *Inheritance*

# abstract class
we can not make an object of it. It is just like a definition sheet.

# inheritance
we use inheritance when we feel everything that parent has also makes sense for child.

it promotes code reuse (it is a side effect, we can do it via making a common class as well)

the actual idea of inheritance is not code reuse, that's just a side effect. Actually, if there is a class whose everything can be used as it is by another class then we proceed with inheritance

*is a* relationship is inheritance

# composition

*has a* relationship

> composition is preferred over inheritance

# OCP
open for extension, closed for modification