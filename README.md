## 关于Java的shallow copy和deep copy
### shoallow copy
浅拷贝，只拷贝成员变量的值；
具体而言就是，拷贝基本类型的成员变量，非基本类型的成员变量仍然指向原对象。
### deep copy
深拷贝，拷贝成员变量的值，同时拷贝成员变量指向的对象。
具体而言就是，拷贝基本类型的成员变量，非基本类型的成员变量指向新的对象。

**注意：**如果非基本类型的成员变量是不可变类型，如`String`类，则不需要特别的实现深拷贝，直接简单的浅拷贝即可。

### 执行deep copy的根本原因
执行deep copy的根本原因在于，类的非基本类型变量指向的对象是可变的；若对象是不可变的或者在其生命周期内都是不可变的，则使用浅拷贝即可，而无需使用复杂的深拷贝。

### 实现clone()方法的步骤
* 为实现`clone()`方法的类添加标记接口`Cloneable`
<br>如果不添加该标记接口，编译时会抛出异常。
* 在类`Obj`中覆盖`Object`类的`clone()`方法
* 执行浅拷贝
<br>在`clone()`方法中调用`Object`类的`clone()`方法 <br> `o=(Obj)super.clone();`
* 执行深拷贝
<br>在`clone()`方法中，对每一个非基本类型变量`attr`调用`attr`的`clone()`方法  <br>
`o.attr=this.getAttr().clone();`
* 返回浅/深拷贝对象`o`

### 代码复现
直接将代码在Java的命令行下执行，使用两个简单命令：`javac classname.java`和`java classname`

### 更多问题可以联系[wyue_email@163.com](wyue_email@163.com)