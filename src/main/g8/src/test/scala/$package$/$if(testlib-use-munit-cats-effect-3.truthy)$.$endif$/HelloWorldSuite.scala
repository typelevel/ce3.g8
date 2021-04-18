package $package$

import cats.effect.{IO, SyncIO}
import munit.CatsEffectSuite

class HelloWorldSuite extends CatsEffectSuite {

  test("test hello world says hi") {
    HelloWorld.say$if(scala3.truthy)$()$endif$.map(it => assertEquals(it, "Hello Cats!"))
  }
}
