# Clojure webapp tutorial

This tutorial is meant for clojure newbies to get their hands dirty with a simple
webapp to develop.

# Instructions

In the following we'll be using the syntax from BASH, the popular *nix shell environment. Please adapt as needed.

## Prerequisites

You should have installed the following tools on your laptop:

- a recent Java Development Kit (>= v7)
- [leiningen](https://github.com/technomancy/leiningen), the most used clojure build tool
- an editor / IDE of choice [with support for Clojure](http://dev.clojure.org/display/doc/IDEs+and+Editors)
- [git](https://git-scm.com/), the version control system

## Get the code

Open up the shell of your liking and point it to a folder where you would like to
store the tutorial resources.

```shell
cd /path/to/my/projects
```

Then, clone this repository:

```shell
git clone https://github.com/CodeHopperNL/clojure-webapp-tutorial.git
cd clojure-webapp-tutorial
```

### What's in the package

The code you just downloaded is nothing more than a project created from a leiningen
[template](https://github.com/technomancy/leiningen/blob/master/doc/TEMPLATES.md) called
[`reagent-template`](https://github.com/reagent-project/reagent-template). It includes
the following goodies (only highlights here, look inside the code for the details):

- clojure code for both the server and client side
- [reagent](https://github.com/reagent-project/reagent), a popular yet very minimal clojurescript framework wrapping [react](https://facebook.github.io/react/)
- [compojure](https://github.com/weavejester/compojure), a server-side clojure routing library to dispatch HTTP requests to clojure functions
- [figwheel](https://github.com/bhauman/lein-figwheel), the awesome tool that automagically reloads your clojure and clojurescript code upon save
- an embedded [jetty](http://www.eclipse.org/jetty/) server to run the webapp

## Run your app

To run your app, the easiest is to shoot the following command at the terminal
once inside the code you previously checked out on git:

```shell
lein figwheel
```

This command will do many things for you. Most importantly, it will start your
app and an [nREPL](https://github.com/clojure/tools.nrepl) server that you can use
to connect your IDE to the running application.

After a while, you should see the following text being logged:

```
Prompt will show when Figwheel connects to your application
```

That means that your application is up and running, and you can point your browser
to `http://localhost:3449`
