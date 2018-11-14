# base-app
プルジェクト作成の基盤

参考URL

html5 pattern

https://qiita.com/ka215/items/795a179041c705bef03b

jenkins

for /f "tokens=1" %%i in ('jps -l ^| find "Spring_Boot_Application.jar"') do taskkill /pid %%i /f

## swagger 
https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api

## controller test
https://qiita.com/ryo2132/items/ec10116238e1e1f333a1

## junit結合テスト
```
		Resource resource = new ClassPathResource(file, getClass());

		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(resource);
		populator.setContinueOnError(continueOnError);
		populator.execute(data);
```
- Fixture
