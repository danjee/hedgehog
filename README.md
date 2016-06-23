# Hedgehog

### Hedgehog is a Spring, Guice and Weld CDI bean injector in non-managed java classes.

##### Inspired from Wicket injectors

## Usage sample:

### Guice


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

A business panel:

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
	
	private MetaDataEntry<?>[] metaData;
	
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

	public void setMetaData(MetaDataKey<Stinger> key, Object object) {
		metaData = key.set(metaData, object);
	}
}
```

### Spring

### Weld