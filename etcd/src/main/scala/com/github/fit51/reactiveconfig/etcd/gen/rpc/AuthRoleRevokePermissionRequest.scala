// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.github.fit51.reactiveconfig.etcd.gen.rpc

@SerialVersionUID(0L)
final case class AuthRoleRevokePermissionRequest(
    role: _root_.scala.Predef.String = "",
    key: _root_.scala.Predef.String = "",
    rangeEnd: _root_.scala.Predef.String = ""
    ) extends scalapb.GeneratedMessage with scalapb.Message[AuthRoleRevokePermissionRequest] with scalapb.lenses.Updatable[AuthRoleRevokePermissionRequest] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = role
        if (__value != "") {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
        }
      };
      
      {
        val __value = key
        if (__value != "") {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
        }
      };
      
      {
        val __value = rangeEnd
        if (__value != "") {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(3, __value)
        }
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
      {
        val __v = role
        if (__v != "") {
          _output__.writeString(1, __v)
        }
      };
      {
        val __v = key
        if (__v != "") {
          _output__.writeString(2, __v)
        }
      };
      {
        val __v = rangeEnd
        if (__v != "") {
          _output__.writeString(3, __v)
        }
      };
    }
    def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest = {
      var __role = this.role
      var __key = this.key
      var __rangeEnd = this.rangeEnd
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 10 =>
            __role = _input__.readString()
          case 18 =>
            __key = _input__.readString()
          case 26 =>
            __rangeEnd = _input__.readString()
          case tag => _input__.skipField(tag)
        }
      }
      com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest(
          role = __role,
          key = __key,
          rangeEnd = __rangeEnd
      )
    }
    def withRole(__v: _root_.scala.Predef.String): AuthRoleRevokePermissionRequest = copy(role = __v)
    def withKey(__v: _root_.scala.Predef.String): AuthRoleRevokePermissionRequest = copy(key = __v)
    def withRangeEnd(__v: _root_.scala.Predef.String): AuthRoleRevokePermissionRequest = copy(rangeEnd = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = role
          if (__t != "") __t else null
        }
        case 2 => {
          val __t = key
          if (__t != "") __t else null
        }
        case 3 => {
          val __t = rangeEnd
          if (__t != "") __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(role)
        case 2 => _root_.scalapb.descriptors.PString(key)
        case 3 => _root_.scalapb.descriptors.PString(rangeEnd)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest
}

object AuthRoleRevokePermissionRequest extends scalapb.GeneratedMessageCompanion[com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest] = this
  def fromFieldsMap(__fieldsMap: scala.collection.immutable.Map[_root_.com.google.protobuf.Descriptors.FieldDescriptor, _root_.scala.Any]): com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest = {
    _root_.scala.Predef.require(__fieldsMap.keys.forall(_.getContainingType() == javaDescriptor), "FieldDescriptor does not match message type.")
    val __fields = javaDescriptor.getFields
    com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest(
      __fieldsMap.getOrElse(__fields.get(0), "").asInstanceOf[_root_.scala.Predef.String],
      __fieldsMap.getOrElse(__fields.get(1), "").asInstanceOf[_root_.scala.Predef.String],
      __fieldsMap.getOrElse(__fields.get(2), "").asInstanceOf[_root_.scala.Predef.String]
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest(
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Predef.String]).getOrElse("")
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = RpcProto.javaDescriptor.getMessageTypes.get(61)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = RpcProto.scalaDescriptor.messages(61)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest(
    role = "",
    key = "",
    rangeEnd = ""
  )
  implicit class AuthRoleRevokePermissionRequestLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest](_l) {
    def role: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.role)((c_, f_) => c_.copy(role = f_))
    def key: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.key)((c_, f_) => c_.copy(key = f_))
    def rangeEnd: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.rangeEnd)((c_, f_) => c_.copy(rangeEnd = f_))
  }
  final val ROLE_FIELD_NUMBER = 1
  final val KEY_FIELD_NUMBER = 2
  final val RANGE_END_FIELD_NUMBER = 3
  def of(
    role: _root_.scala.Predef.String,
    key: _root_.scala.Predef.String,
    rangeEnd: _root_.scala.Predef.String
  ): _root_.com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest = _root_.com.github.fit51.reactiveconfig.etcd.gen.rpc.AuthRoleRevokePermissionRequest(
    role,
    key,
    rangeEnd
  )
}
