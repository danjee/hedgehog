# Hedgehog

[![Gitter](https://badges.gitter.im/danjee/hedgehog.svg)](https://gitter.im/danjee/hedgehog?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg?maxAge=2592000)]()
[![Stories in Ready](https://badge.waffle.io/danjee/hedgehog.png?label=ready&title=Ready)](https://waffle.io/danjee/hedgehog)
[![Travis CI Build Status](https://travis-ci.org/danjee/hedgehog.png)](https://travis-ci.org/danjee/hedgehog)
[![Coverage Status](https://coveralls.io/repos/github/danjee/hedgehog/badge.svg?branch=master)](https://coveralls.io/github/danjee/hedgehog?branch=master&cache=nocache1)
[![Maven Central](http://img.shields.io/maven-central/v/ro.fortsoft/hedgehog.svg)](http://search.maven.org/#search|ga|1|ro.fortsoft.hedgehog)

<!--
[![Issue Stats](http://www.issuestats.com/github/danjee/hedgehog/badge/issue?style=flat)](http://www.issuestats.com/github/danjee/hedgehog)
[![Issue Stats](http://www.issuestats.com/github/danjee/hedgehog/badge/pr?style=flat)](http://www.issuestats.com/github/danjee/hedgehog)
-->



### Hedgehog is a Spring, Guice and Weld CDI bean injector in non-managed business java classes. 

##### Inspired from Wicket injectors

Use it if you want to inject some managed components in legacy classes or classes that you simple do not want to have it managed like Swing or JavaFX panels. 

## Usage sample:

### Spring

Use the dependency:

```xml
<dependency>
	<groupId>ro.fortsoft</groupId>
	<artifactId>hedgehog-spring</artifactId>
	<version>0.0.2</version>
</dependency>
```

The configuration class:

```java
@Configuration
@ComponentScan(basePackages = "ro.fortsoft.beans")
public class AppConfig {

	@Bean
	public Child getChild(){
		return new Child();
	}

}
```

The bean:

```java
@Component
public class Child {
	@Override
	public String toString() {
		return "I'm a child";
	}
}
```
A business panel (non managed bean)

```java
public class Panel {

	@Sting
	private Child child;
	
	public Panel(){
		Stinger.get().sting(this);
	}
	
	public void test() {
		System.out.println(child);
	}
}
```

Main class
```java
public class App implements StingAwareApplication {

	private MetaDataEntry<Stinger>[] metaData;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		SpringComponentStinger stinger = new SpringComponentStinger(context);
		App app = new App();
		stinger.bind(app);
		Panel panel = new Panel();
		panel.test();
	}

	public Stinger getMetaData(MetaDataKey<Stinger> key) {
        return key.get(metaData);
    }

    public void setMetaData(final MetaDataKey<Stinger> key, final Stinger object) {
        metaData = key.set(metaData, object);
    }
}
```

### Guice

Use the dependency:

```xml
<dependency>
	<groupId>ro.fortsoft</groupId>
	<artifactId>hedgehog-guice</artifactId>
	<version>0.0.2</version>
</dependency>
```

The Guice module class:

```java
public class GuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ContactService.class).to(InMemoryContactService.class).asEagerSingleton();
	}
}
```

The beans:

```java
public interface ContactService {
	
	String add(String word);
	
	void modify(String word);
	
	void delete(String word);
}
```

```java
public class InMemoryContactService implements ContactService {

	public String add(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	public void modify(String word) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String word) {
		// TODO Auto-generated method stub
		
	}
}

```

A business panel (non managed bean)

```java
public class Panel {

	@Sting
	private ContactService contactService;
	
	public Panel(){
		Stinger.get().sting(this);
	}
	
	public void test(){
		System.out.println(contactService);
	}
}

```

Main class
```java
public class App implements StingAwareApplication {
	
	private MetaDataEntry<Stinger>[] metaData;
	
	public static void main(String[] args) {
		 Injector injector = Guice.createInjector(new GuiceModule());
		 GuiceComponentsStinger stinger = new GuiceComponentsStinger(injector);
		 App app = new App();
		 stinger.bind(app);
		 Panel panel = new Panel();
		 panel.test();
	}

	public Stinger getMetaData(MetaDataKey<Stinger> key) {
        return key.get(metaData);
    }

    public void setMetaData(final MetaDataKey<Stinger> key, final Stinger object) {
        metaData = key.set(metaData, object);
    }
}
```

### Weld

Use the dependency:

```xml
<dependency>
	<groupId>ro.fortsoft</groupId>
	<artifactId>hedgehog-weld</artifactId>
	<version>0.0.2</version>
</dependency>
```

The service class

```java
public class Child {
	@Override
	public String toString() {
		return "I'm a child";
	}
}
```

A business panel (non managed bean)

```java
public class Panel {

	@Sting
	private Child child;
	
	public Panel(){
		Stinger.get().sting(this);
	}
	
	public void test() {
		System.out.println(child);
	}
}
```

Main class

```java
public class Main implements StingAwareApplication {

	private MetaDataEntry<Stinger>[] metaData;

	public static void main(String[] args) {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();

		WeldComponentStinger stinger = new WeldComponentStinger(container);
		Main test = new Main();
		stinger.bind(test);
		Panel panel = new Panel();
		panel.test();
	}

	public Stinger getMetaData(MetaDataKey<Stinger> key) {
        return key.get(metaData);
    }

    public void setMetaData(final MetaDataKey<Stinger> key, final Stinger object) {
        metaData = key.set(metaData, object);
    }
}
```

## Versioning

Hedgehog will be maintained under the Semantic Versioning guidelines as much as possible.

Releases will be numbered with the follow format:

`<major>.<minor>.<patch>`

And constructed with the following guidelines:

* Breaking backward compatibility bumps the major
* New additions without breaking backward compatibility bumps the minor
* Bug fixes and misc changes bump the patch

For more information on SemVer, please visit http://semver.org.