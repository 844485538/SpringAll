# Thymeleaf
Thymeleaf是一种用于Web和独立环境的现代服务器端的Java模板引擎。
</br>
Thymeleaf的主要目标是将优雅的自然模板带到开发工作流程中，并将HTML在浏览器中正确显示，并且可以作为静态原型，让开发团队能更容易地协作。Thymeleaf能够处理HTML，XML，JavaScript，CSS甚至纯文本。

## 可以处理6种模板
###标记模板模式：HTML
HTML模板模式将允许任何类型的HTML输入，包括HTML5，HTML4和XHTML。 将不会执行验证或格式检查，并且在输出中尽可能地遵守模板代码/结构
###标记模板模式：XML
XML模板模式将允许XML输入。 在这种情况下，代码应该是格式良好的 - 没有未封闭的标签，没有未加引号的属性等等，如果发现格式错误，解析器将会抛出异常。 请注意，将不会执行验证(针对DTD或XML模式)。
###文本模板模式：TEXT
TEXT模板模式将允许对非标记性质的模板使用特殊语法。 这种模板的例子可能是文本电子邮件或模板文档。 请注意，HTML或XML模板也可以作为TEXT处理，在这种情况下，它们不会被解析为标记，而每个标记，DOCTYPE，注释等都将被视为纯文本。
###文本模板模式：JAVASCRIPT
JAVASCRIPT模板模式将允许处理Thymeleaf应用程序中的JavaScript文件。这意味着能够像在HTML文件中一样使用JavaScript文件中的模型数据，但是使用特定于JavaScript的集成(例如专门转义或自然脚本)。 JAVASCRIPT模板模式被认为是文本模式，因此使用与TEXT模板模式相同的特殊语法。
###文本模板模式：CSS
CSS模板模式将允许处理Thymeleaf应用程序中涉及的CSS文件。类似于JAVASCRIPT模式，CSS模板模式也是文本模式，并使用TEXT模板模式中的特殊处理语法。
###无操作模板模式：RAW
RAW模板模式根本不会处理模板。它意味着用于将未触及的资源(文件，URL响应等)插入正在处理的模板中。例如，可以将HTML格式的外部非受控资源包含在应用程序模板中，从而安全地知道这些资源可能包含的任何Thymeleaf代码都不会被执行。

##标准方言
Thymeleaf是非常非常可扩展的，它允许自定义的名字来定义一组模板属性(或者甚至是标签)，用自定语法评估计算表达式和应用逻辑。它更像是一个模板引擎框架。

它还带有一些称为标准方言(称为Standard和SpringStandard)的东西，它们定义了一组功能，这些功能应该足以满足大多数情况。可以识别这些标准方言在模板中的使用，因为它将包含以th前缀开头的属性，如<span th:text="...">。

###标准表达式：
大多数Thymeleaf属性允许将它们的值设置为或包含表达式，由于它们使用的方言，我们将其称为标准表达式。这些表达式可以有五种类型.
####${...} : 变量表达式。
	变量表达式是OGNL表达式:
	`${session.user.name}`
	它们作为属性值或作为它们的一部分，取决于属性:
	`<span th:text="${book.author.name}">`
	但是不仅在涉及输出的场景中找到变量表达式，而且还可以使用更复杂的处理方式，如:条件，迭代…等等
	`<li th:each="book : ${books}">`
	TIPS；${books}从上下文中选择名为books的变量，并在th:each中使用循环将其评估为迭代器。
#### \*{...} : 选择表达式。
#### \#{...} : 消息 (i18n) 表达式。
#### \@{...} : 链接 (URL) 表达式。
#### \~{...} : 片段表达式。