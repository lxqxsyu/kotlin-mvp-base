## 说明

本框架搭建很大一部分参考和直接使用[KotlinMvp](https://github.com/git-xuhao/KotlinMvp)

KotlinMvp是基于Kotlin+MVP+Retrofit+RxJava+Glide 等架构实现短视频类小项目。

### 使用的第三方库

- Retrofit
- rxJava
- rxLifecycle
- Glide
- LiveEventBus

## 使用方式

下载源码，引入base模块， glide图片加载可选。

```groovy
implementation project(":base")
implementation project(":glideimageview")
```

