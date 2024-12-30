package com.github.argon4w.tmwya.mixins;

import com.llamalad7.mixinextras.sugar.Local;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketDecoder;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PacketDecoder.class)
public class PacketDecoderMixin {
    @ModifyArg(method = "decode", at = @At(value = "INVOKE", target = "Ljava/io/IOException;<init>(Ljava/lang/String;)V"))
    public String provideDetailedMessageForCustomPayload(String message, @Local(index = 5, name = "packet") Packet<?> packet, @Local(index = 2, name = "in", argsOnly = true) ByteBuf in) {

        if (packet instanceof ClientboundCustomPayloadPacket(CustomPacketPayload payload)) {
            return "CustomPayloadPacket \"%s\" was larger than I expected, found %d bytes extra whilst reading packet.".formatted(payload.type().id(), in.readableBytes());
        }

        return message;
    }
}
