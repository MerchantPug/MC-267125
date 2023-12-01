package net.merchantpug.mc267125.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

@Mixin(MinecraftServer.class)
public abstract class MinecratServerMixin {
	@Shadow public abstract PlayerList getPlayerList();

	@Inject(method = "method_29440", at = @At("TAIL"))
	private void mc267125$fix(Collection collection, MinecraftServer.ReloadableResources reloadableResources, CallbackInfo ci) {
		this.getPlayerList().getPlayers().forEach(this.getPlayerList()::sendPlayerPermissionLevel);
	}
}