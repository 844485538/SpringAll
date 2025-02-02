# Thymeleaf
Thymeleaf是一种用于Web和独立环境的现代服务器端的Java模板引擎。
</br>
Thymeleaf的主要目标是将优雅的自然模板带到开发工作流程中，并将HTML在浏览器中正确显示，并且可以作为静态原型，让开发团队能更容易地协作。Thymeleaf能够处理HTML，XML，JavaScript，CSS甚至纯文本。

## 可以处理6种模板
### 标记模板模式：HTML
HTML模板模式将允许任何类型的HTML输入，包括HTML5，HTML4和XHTML。 将不会执行验证或格式检查，并且在输出中尽可能地遵守模板代码/结构
### 标记模板模式：XML
XML模板模式将允许XML输入。 在这种情况下，代码应该是格式良好的 - 没有未封闭的标签，没有未加引号的属性等等，如果发现格式错误，解析器将会抛出异常。 请注意，将不会执行验证(针对DTD或XML模式)。
### 文本模板模式：TEXT
TEXT模板模式将允许对非标记性质的模板使用特殊语法。 这种模板的例子可能是文本电子邮件或模板文档。 请注意，HTML或XML模板也可以作为TEXT处理，在这种情况下，它们不会被解析为标记，而每个标记，DOCTYPE，注释等都将被视为纯文本。
### 文本模板模式：JAVASCRIPT
JAVASCRIPT模板模式将允许处理Thymeleaf应用程序中的JavaScript文件。这意味着能够像在HTML文件中一样使用JavaScript文件中的模型数据，但是使用特定于JavaScript的集成(例如专门转义或自然脚本)。 JAVASCRIPT模板模式被认为是文本模式，因此使用与TEXT模板模式相同的特殊语法。
### 文本模板模式：CSS
CSS模板模式将允许处理Thymeleaf应用程序中涉及的CSS文件。类似于JAVASCRIPT模式，CSS模板模式也是文本模式，并使用TEXT模板模式中的特殊处理语法。
### 无操作模板模式：RAW
RAW模板模式根本不会处理模板。它意味着用于将未触及的资源(文件，URL响应等)插入正在处理的模板中。例如，可以将HTML格式的外部非受控资源包含在应用程序模板中，从而安全地知道这些资源可能包含的任何Thymeleaf代码都不会被执行。

## 标准方言
Thymeleaf是非常非常可扩展的，它允许自定义的名字来定义一组模板属性(或者甚至是标签)，用自定语法评估计算表达式和应用逻辑。它更像是一个模板引擎框架。

它还带有一些称为标准方言(称为Standard和SpringStandard)的东西，它们定义了一组功能，这些功能应该足以满足大多数情况。可以识别这些标准方言在模板中的使用，因为它将包含以th前缀开头的属性，如<span th:text="...">。

### 标准表达式：
大多数Thymeleaf属性允许将它们的值设置为或包含表达式，由于它们使用的方言，我们将其称为标准表达式。这些表达式可以有五种类型.
#### ${...} : 变量表达式。
#### \*{...} : 选择表达式。
#### \#{...} : 消息 (i18n) 表达式。
#### \@{...} : 链接 (URL) 表达式。
#### \~{...} : 片段表达式。

## 标准URL语法：
Thymeleaf标准方言(称为Standard和SpringStandard)提供了一种在Web应用程序中轻松创建URL的方法，以便它们包含任何所需的URL工件。

### 绝对网址
绝对URL用于创建到其他服务器的链接。它们需要指定一个协议名称(http://或https://)开头。</br>
`<a th:href="@{https://www.baidu.com}">百度</a>`</br>
最后生成的HTML代码如下:</br>
`<a href="https://www.baidu.com">`</br>
### 上下文相关URL
最常用的URL类型是上下文相关的。 这些URL是一旦安装在服务器上，就会与Web应用程序根相关联URL。相当于调用内部接口</br>
`<a th:href="@{/order/list}">`</br>
最后生成的HTML代码如下:</br>
`<a href="/myapp/order/list">`</br>
### 具有参数的跳转
`<a th:href="@{/order/list(id=3,name=4)}">`</br>
最后生成的HTML代码如下:</br>
`<a href="/myapp/order/list?id=3&name=4">`</br>
### 使用占位符
`<a th:href="@{/order/{id}/details(id=3,action='show_all')}">`</br>
最后生成的HTML代码如下:</br>
`<a href="/order/3/details?action=show_all">`</br>

## 标签的应用
### 显示Bean的值
```
Java:
Product product = new Product("花生油", 129, sdf.parse("2018-02-18"));
model.addAttribute("product", product);

html:
<div th:text="${product.description}"></div>
```

### 格式化文本
```
对数字进行格式化：
<div th:text="${'￥' + #numbers.formatDecimal(product.price, 1, 2)}">

对日期进行格式化
<div th:text="${#dates.format(product.availableFrom, 'yyyy-MM-dd')}">
```

### 字符串拼接
```
 <dd th:text="${'￥' + #numbers.formatDecimal(product.price, 1, 2)}">
```

### 字符串转义 
```
Java:
String html =  "Welcome to our <b>fantastic</b> grocery store!";

html:
<div th:text="${html}">Some escaped text</div>
显示：原String

<div th:utext="${html}">Some unescaped text</div>
显示：将<b>转为了html标签
```

### 对list进行迭代
```
<tr th:each="product : ${productList}">
	<!-- 显示行号 -->
	<td th:text="${productStat.count}">1</td>
	<td th:text="${product.description}">Red chair</td>
	<td th:text="${'￥' + #numbers.formatDecimal(product.price, 1, 2)}">￥350</td>
	<td th:text="${#dates.format(product.availableFrom, 'dd-MM-yyyy')}">2018-02-20</td>
</tr>
```

### 条件判断
```
th:if 	th:if="${product.price gt 100}"
th:unless

th:switch
th:case
<td th:switch="${product.saleType}">
	<span th:case="'CG'">闪购</span>
	<span th:case="'PT'">拼团</span>
	<span th:case="'CX'">促销</span>
	<span th:case="*">其它</span>
</td>
```

### 表单
```
Java:
@RequestMapping(value="/add",method=RequestMethod.POST)
public String add(@ModelAttribute UserForm user){
    String username = user.getUsername();
    String password = user.getPassword();
    return username+"__"+password;
}

html:
<form action="#" th:action="@{/add}" th:object="${userInfo}" method="post">  
  <input type="text" th:field="*{username}" />  
  <input type="text" th:field="*{password}" />  
  <input type="submit" />  
</form>
```