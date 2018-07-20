package io.udash.web.guide.views.frontend.demos

import io.udash._
import io.udash.bootstrap.BootstrapStyles
import io.udash.bootstrap.form.UdashInputGroup
import io.udash.web.commons.views.Component
import io.udash.web.guide.styles.partials.GuideStyles

import scalatags.JsDom

class TextInputDemoComponent extends Component {
  import JsDom.all._

  val name: Property[String] = Property("")
  val password: Property[String] = Property("")
  val age: Property[Int] = Property(1)

  override def getTemplate: Modifier = div(id := "inputs-demo", GuideStyles.frame, GuideStyles.useBootstrap)(
    form(BootstrapStyles.containerFluid)(
      inputs(), br, inputs()
    )
  )

  private def inputs() = div(BootstrapStyles.row)(
    div(BootstrapStyles.Grid.colMd4)(
      UdashInputGroup()(
        UdashInputGroup.input(
          TextInput(name)(placeholder := "Input your name...", maxlength := "6").render
        ),
        UdashInputGroup.append(span(BootstrapStyles.Form.inputGroupText)(bind(name)))
      ).render
    ),
    div(BootstrapStyles.Grid.colMd4)(
      UdashInputGroup()(
        UdashInputGroup.input(
          PasswordInput(password)(placeholder := "Input your password...", maxlength := "6").render
        ),
        UdashInputGroup.append(span(BootstrapStyles.Form.inputGroupText)(bind(password)))
      ).render
    ),
    div(BootstrapStyles.Grid.colMd4)(
      UdashInputGroup()(
        UdashInputGroup.input(
          NumberInput(age.transform(_.toString, Integer.parseInt))(maxlength := "6").render
        ),
        UdashInputGroup.append(span(BootstrapStyles.Form.inputGroupText)(bind(age)))
      ).render
    )
  )
}
