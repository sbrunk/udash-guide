package io.udash.web.guide.views.frontend.demos

import io.udash._
import io.udash.bootstrap.BootstrapStyles
import io.udash.bootstrap.form.UdashInputGroup
import io.udash.web.commons.views.Component
import io.udash.web.guide.styles.partials.GuideStyles
import org.scalajs.dom.html.{Select => _}

import scalatags.JsDom

class SelectDemoComponent extends Component {
  import JsDom.all._

  sealed trait Fruit
  case object Apple extends Fruit
  case object Orange extends Fruit
  case object Banana extends Fruit

  val favoriteFruit: Property[Fruit] = Property[Fruit](Apple)
  val favoriteFruitString = favoriteFruit.transform(
    (f: Fruit) => f.toString,
    (s: String) => s match {
      case "Apple" => Apple
      case "Orange" => Orange
      case "Banana" => Banana
    }
  )

  override def getTemplate: Modifier = div(id := "select-demo", GuideStyles.frame, GuideStyles.useBootstrap)(
    form(BootstrapStyles.containerFluid)(
      div(BootstrapStyles.row)(
        div(
          selector()
        ),
        br(),
        div(
          selector()
        )
      )
    )
  )

  def selector() =
    UdashInputGroup()(
      UdashInputGroup.prependText("Fruits:"),
      UdashInputGroup.append(
        div(BootstrapStyles.Form.inputGroupText)(
          Select(
            favoriteFruitString, Seq(Apple, Orange, Banana).map(_.toString).toSeqProperty
          )(Select.defaultLabel, BootstrapStyles.Form.formControl).render
        )
      ),
      UdashInputGroup.appendText(span(cls := "select-demo-fruits")(bind(favoriteFruit)))
    ).render
}
