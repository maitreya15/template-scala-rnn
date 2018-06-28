package org.template.rnn

import org.apache.predictionio.controller.IEngineFactory
import org.apache.predictionio.controller.Engine

case class Query(content: String) extends Serializable

case class PredictedResult(sentiments: Int) extends Serializable

object Engine extends IEngineFactory {
  def apply() = {
    new Engine(
      classOf[DataSource],
      classOf[Preparator],
      Map("rnn" -> classOf[Algorithm]),
      classOf[Serving])
  }
}
