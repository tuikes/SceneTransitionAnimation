# SceneTransitionAnimation
activity间跳转时增加动画是很常见的需求，我花了些时间整理了一下，包括使用传统补间动画以及转场动画（API>=21）的方式实现 。

方式一：在调用startActivity或者finish activity时，使用overridePendingTransition实现

![ABC](https://github.com/tuikes/MarkdownPhotos/blob/master/one.gif) 


方式二：在主题中设置，如果是application引用的主题中设置，则对整个app均有影响。

![ABC](https://github.com/tuikes/MarkdownPhotos/blob/master/two.gif) 


方式三：通过使用系统自带的转场动画效果（Slide/Explode/Fade）方式打开activity

![ABC](https://github.com/tuikes/MarkdownPhotos/blob/master/three.gif) 


方式四：通过在主题中设置转场动画（Slide/Explode/Fade）实现；如果是在application引用的主题中设置，则对整个app均有影响。

![ABC](https://github.com/tuikes/MarkdownPhotos/blob/master/four.gif) 


方式五：通过在转场动画中增加共享元素实现activity跳转时相关元素动画效果

![ABC](https://github.com/tuikes/MarkdownPhotos/blob/master/five.gif) 


方式六：通过在转场动画中增加多个共享元素实现activity跳转时相关元素动画效果

![ABC](https://github.com/tuikes/MarkdownPhotos/blob/master/six.gif) 
