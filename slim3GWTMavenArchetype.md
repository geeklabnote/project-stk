# 使い方 #

mavenをインストール済みの前提です。 & 現在のarchetypeはeclipseを利用する前提で作成しています。

  1. コマンドラインにて以下を実行します。
```
mvn archetype:generate -DarchetypeCatalog=http://project-stk.googlecode.com/svn/trunk/repository
```

  1. どのプロジェクトを作成するかを求められるので、説明を読み任意の番号を入力してください。
  1. groupId, artifactId, version, package等々の入力を求められるので任意で入力します。
  1. 最後に、入力した値の確認を求められるので、問題なければ "Y" を入力します。
  1. maven用のslim3、gwtプロジェクトが作成されます。
  1. 作成されたフォルダに移動し、以下のコマンドを入力します。
```
mvn eclipse:eclipse
```
  1. mavenが起動し、eclipse用のプロジェクト設定がされます。
  1. 成功したら、eclipseから対象プロジェクトをインポートしてください。

# 注意 #
この設定で利用されるappengine、gwtはeclipseの設定と、pom.xmlに記述されている者が同じでなければなりません。
appengine、gwtは初期時にはeclipseでデフォルトで設定されているクラスパスコンテナを利用しますので、お気を付け下さい。

svnでブランチを作成した場合など、artifactIdとプロジェクトのフォルダ名が異なると、
Eclipse利用時にエラーが発生します。

エラーが発生する場合はpom.xml内の
```
  <factorypathentry kind="WKSPJAR" id="/${artifactId}/${eclipse.lib}/slim3-gen-${slim3.version}.jar" enabled="true" runInBatchMode="false"/>

```
の部分の${artifactId}をプロジェクト名に変更してください。

例:
```
  <factorypathentry kind="WKSPJAR" id="/foo.bar-branch/${eclipse.lib}/slim3-gen-${slim3.version}.jar" enabled="true" runInBatchMode="false"/>

```