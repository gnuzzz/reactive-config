// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.github.fit51.reactiveconfig.etcd.gen.rpc

@SerialVersionUID(0L)
final case class RequestOp(
    request: com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.Empty
    ) extends scalapb.GeneratedMessage with scalapb.Message[RequestOp] with scalapb.lenses.Updatable[RequestOp] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      if (request.requestRange.isDefined) {
        val __value = request.requestRange.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      if (request.requestPut.isDefined) {
        val __value = request.requestPut.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      if (request.requestDeleteRange.isDefined) {
        val __value = request.requestDeleteRange.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      if (request.requestTxn.isDefined) {
        val __value = request.requestTxn.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      __size
    }
    final override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      request.requestRange.foreach { __v =>
        val __m = __v
        _output__.writeTag(1, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      request.requestPut.foreach { __v =>
        val __m = __v
        _output__.writeTag(2, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      request.requestDeleteRange.foreach { __v =>
        val __m = __v
        _output__.writeTag(3, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      request.requestTxn.foreach { __v =>
        val __m = __v
        _output__.writeTag(4, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
    }
    def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp = {
      var __request = this.request
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 10 =>
            __request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestRange(_root_.scalapb.LiteParser.readMessage(_input__, request.requestRange.getOrElse(com.github.fit51.reactiveconfig.etcd.gen.rpc.RangeRequest.defaultInstance)))
          case 18 =>
            __request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestPut(_root_.scalapb.LiteParser.readMessage(_input__, request.requestPut.getOrElse(com.github.fit51.reactiveconfig.etcd.gen.rpc.PutRequest.defaultInstance)))
          case 26 =>
            __request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestDeleteRange(_root_.scalapb.LiteParser.readMessage(_input__, request.requestDeleteRange.getOrElse(com.github.fit51.reactiveconfig.etcd.gen.rpc.DeleteRangeRequest.defaultInstance)))
          case 34 =>
            __request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestTxn(_root_.scalapb.LiteParser.readMessage(_input__, request.requestTxn.getOrElse(com.github.fit51.reactiveconfig.etcd.gen.rpc.TxnRequest.defaultInstance)))
          case tag => _input__.skipField(tag)
        }
      }
      com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp(
          request = __request
      )
    }
    def getRequestRange: com.github.fit51.reactiveconfig.etcd.gen.rpc.RangeRequest = request.requestRange.getOrElse(com.github.fit51.reactiveconfig.etcd.gen.rpc.RangeRequest.defaultInstance)
    def withRequestRange(__v: com.github.fit51.reactiveconfig.etcd.gen.rpc.RangeRequest): RequestOp = copy(request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestRange(__v))
    def getRequestPut: com.github.fit51.reactiveconfig.etcd.gen.rpc.PutRequest = request.requestPut.getOrElse(com.github.fit51.reactiveconfig.etcd.gen.rpc.PutRequest.defaultInstance)
    def withRequestPut(__v: com.github.fit51.reactiveconfig.etcd.gen.rpc.PutRequest): RequestOp = copy(request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestPut(__v))
    def getRequestDeleteRange: com.github.fit51.reactiveconfig.etcd.gen.rpc.DeleteRangeRequest = request.requestDeleteRange.getOrElse(com.github.fit51.reactiveconfig.etcd.gen.rpc.DeleteRangeRequest.defaultInstance)
    def withRequestDeleteRange(__v: com.github.fit51.reactiveconfig.etcd.gen.rpc.DeleteRangeRequest): RequestOp = copy(request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestDeleteRange(__v))
    def getRequestTxn: com.github.fit51.reactiveconfig.etcd.gen.rpc.TxnRequest = request.requestTxn.getOrElse(com.github.fit51.reactiveconfig.etcd.gen.rpc.TxnRequest.defaultInstance)
    def withRequestTxn(__v: com.github.fit51.reactiveconfig.etcd.gen.rpc.TxnRequest): RequestOp = copy(request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestTxn(__v))
    def clearRequest: RequestOp = copy(request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.Empty)
    def withRequest(__v: com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request): RequestOp = copy(request = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => request.requestRange.orNull
        case 2 => request.requestPut.orNull
        case 3 => request.requestDeleteRange.orNull
        case 4 => request.requestTxn.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => request.requestRange.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 2 => request.requestPut.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 3 => request.requestDeleteRange.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 4 => request.requestTxn.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp
}

object RequestOp extends scalapb.GeneratedMessageCompanion[com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp] = this
  def fromFieldsMap(__fieldsMap: scala.collection.immutable.Map[_root_.com.google.protobuf.Descriptors.FieldDescriptor, _root_.scala.Any]): com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp = {
    _root_.scala.Predef.require(__fieldsMap.keys.forall(_.getContainingType() == javaDescriptor), "FieldDescriptor does not match message type.")
    val __fields = javaDescriptor.getFields
    com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp(
      request = __fieldsMap.get(__fields.get(0)).asInstanceOf[_root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.RangeRequest]].map(com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestRange)
    .orElse[com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request](__fieldsMap.get(__fields.get(1)).asInstanceOf[_root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.PutRequest]].map(com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestPut))
    .orElse[com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request](__fieldsMap.get(__fields.get(2)).asInstanceOf[_root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.DeleteRangeRequest]].map(com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestDeleteRange))
    .orElse[com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request](__fieldsMap.get(__fields.get(3)).asInstanceOf[_root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.TxnRequest]].map(com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestTxn))
    .getOrElse(com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.Empty)
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp(
        request = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).flatMap(_.as[_root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.RangeRequest]]).map(com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestRange)
    .orElse[com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request](__fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).flatMap(_.as[_root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.PutRequest]]).map(com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestPut))
    .orElse[com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request](__fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).flatMap(_.as[_root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.DeleteRangeRequest]]).map(com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestDeleteRange))
    .orElse[com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request](__fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).flatMap(_.as[_root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.TxnRequest]]).map(com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestTxn))
    .getOrElse(com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.Empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = RpcProto.javaDescriptor.getMessageTypes.get(7)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = RpcProto.scalaDescriptor.messages(7)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 1 => __out = com.github.fit51.reactiveconfig.etcd.gen.rpc.RangeRequest
      case 2 => __out = com.github.fit51.reactiveconfig.etcd.gen.rpc.PutRequest
      case 3 => __out = com.github.fit51.reactiveconfig.etcd.gen.rpc.DeleteRangeRequest
      case 4 => __out = com.github.fit51.reactiveconfig.etcd.gen.rpc.TxnRequest
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp(
    request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.Empty
  )
  sealed trait Request extends _root_.scalapb.GeneratedOneof {
    def isEmpty: _root_.scala.Boolean = false
    def isDefined: _root_.scala.Boolean = true
    def isRequestRange: _root_.scala.Boolean = false
    def isRequestPut: _root_.scala.Boolean = false
    def isRequestDeleteRange: _root_.scala.Boolean = false
    def isRequestTxn: _root_.scala.Boolean = false
    def requestRange: _root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.RangeRequest] = _root_.scala.None
    def requestPut: _root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.PutRequest] = _root_.scala.None
    def requestDeleteRange: _root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.DeleteRangeRequest] = _root_.scala.None
    def requestTxn: _root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.TxnRequest] = _root_.scala.None
  }
  object Request extends {
    @SerialVersionUID(0L)
    case object Empty extends com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request {
      type ValueType = _root_.scala.Nothing
      override def isEmpty: _root_.scala.Boolean = true
      override def isDefined: _root_.scala.Boolean = false
      override def number: _root_.scala.Int = 0
      override def value: _root_.scala.Nothing = throw new java.util.NoSuchElementException("Empty.value")
    }
  
    @SerialVersionUID(0L)
    final case class RequestRange(value: com.github.fit51.reactiveconfig.etcd.gen.rpc.RangeRequest) extends com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request {
      type ValueType = com.github.fit51.reactiveconfig.etcd.gen.rpc.RangeRequest
      override def isRequestRange: _root_.scala.Boolean = true
      override def requestRange: _root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.RangeRequest] = Some(value)
      override def number: _root_.scala.Int = 1
    }
    @SerialVersionUID(0L)
    final case class RequestPut(value: com.github.fit51.reactiveconfig.etcd.gen.rpc.PutRequest) extends com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request {
      type ValueType = com.github.fit51.reactiveconfig.etcd.gen.rpc.PutRequest
      override def isRequestPut: _root_.scala.Boolean = true
      override def requestPut: _root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.PutRequest] = Some(value)
      override def number: _root_.scala.Int = 2
    }
    @SerialVersionUID(0L)
    final case class RequestDeleteRange(value: com.github.fit51.reactiveconfig.etcd.gen.rpc.DeleteRangeRequest) extends com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request {
      type ValueType = com.github.fit51.reactiveconfig.etcd.gen.rpc.DeleteRangeRequest
      override def isRequestDeleteRange: _root_.scala.Boolean = true
      override def requestDeleteRange: _root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.DeleteRangeRequest] = Some(value)
      override def number: _root_.scala.Int = 3
    }
    @SerialVersionUID(0L)
    final case class RequestTxn(value: com.github.fit51.reactiveconfig.etcd.gen.rpc.TxnRequest) extends com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request {
      type ValueType = com.github.fit51.reactiveconfig.etcd.gen.rpc.TxnRequest
      override def isRequestTxn: _root_.scala.Boolean = true
      override def requestTxn: _root_.scala.Option[com.github.fit51.reactiveconfig.etcd.gen.rpc.TxnRequest] = Some(value)
      override def number: _root_.scala.Int = 4
    }
  }
  implicit class RequestOpLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp](_l) {
    def requestRange: _root_.scalapb.lenses.Lens[UpperPB, com.github.fit51.reactiveconfig.etcd.gen.rpc.RangeRequest] = field(_.getRequestRange)((c_, f_) => c_.copy(request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestRange(f_)))
    def requestPut: _root_.scalapb.lenses.Lens[UpperPB, com.github.fit51.reactiveconfig.etcd.gen.rpc.PutRequest] = field(_.getRequestPut)((c_, f_) => c_.copy(request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestPut(f_)))
    def requestDeleteRange: _root_.scalapb.lenses.Lens[UpperPB, com.github.fit51.reactiveconfig.etcd.gen.rpc.DeleteRangeRequest] = field(_.getRequestDeleteRange)((c_, f_) => c_.copy(request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestDeleteRange(f_)))
    def requestTxn: _root_.scalapb.lenses.Lens[UpperPB, com.github.fit51.reactiveconfig.etcd.gen.rpc.TxnRequest] = field(_.getRequestTxn)((c_, f_) => c_.copy(request = com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request.RequestTxn(f_)))
    def request: _root_.scalapb.lenses.Lens[UpperPB, com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request] = field(_.request)((c_, f_) => c_.copy(request = f_))
  }
  final val REQUEST_RANGE_FIELD_NUMBER = 1
  final val REQUEST_PUT_FIELD_NUMBER = 2
  final val REQUEST_DELETE_RANGE_FIELD_NUMBER = 3
  final val REQUEST_TXN_FIELD_NUMBER = 4
  def of(
    request: com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp.Request
  ): _root_.com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp = _root_.com.github.fit51.reactiveconfig.etcd.gen.rpc.RequestOp(
    request
  )
}
