package com.zfoo.protocol.serializer;

import com.zfoo.protocol.generate.GenerateOperation;
import com.zfoo.protocol.registration.IProtocolRegistration;

import java.io.IOException;
import java.util.List;

/**
 * 协议修改过后的测试流程：
 * 1.测试Java的老协议和新协议的兼容性，NormalObject/ObjectA/ObjectB有几个兼容字段
 * 2.测试Java在字节码增强，CutDown，反射三种情况下的代码下的协议解析的准确性
 * 3.测试resource/compatible中有5种协议兼容情况需要测试
 * 4.1和2总共有2*3*5=30种情况
 * <p>
 * 协议生成修改后的测试流程：
 * 同上，除了反射，总共有2*2*5=20种情况
 *
 * @author godotg
 */
public interface ICodeGenerate {

    void init(GenerateOperation generateOperation);

    /**
     * 将一个包下的协议文件生成在一个协议文件里
     */
    void mergerProtocol(List<IProtocolRegistration> registrations) throws IOException;

    /**
     * 折叠协议，生成协议文件会和Java源文件保持相同的目录结构
     */
    void foldProtocol(List<IProtocolRegistration> registrations) throws IOException;

    /**
     * 默认把所有的协议文件放在同一个更目录下，不做任何操作
     */
    void defaultProtocol(List<IProtocolRegistration> registrations) throws IOException;

}
