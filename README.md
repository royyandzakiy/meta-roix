# meta-roix

A custom Yocto Project layer targeting the Raspberry Pi 4 (64-bit). This is a personal learning project built to explore embedded Linux development with the Yocto Project.

## Overview

`meta-roix` defines the **Roix** distribution — a minimal, headless Linux image based on Poky/Scarthgap with systemd as the init manager. It is designed to run on a Raspberry Pi 4 with Ethernet, UART, I2C, and SPI support.

## Layer Contents

| Path | Description |
|------|-------------|
| `conf/distro/roix.conf` | Distribution configuration (features, init manager, kernel provider) |
| `conf/distro/roix-base.conf` | Minimal variant of the Roix distro |
| `conf/machine/raspberrypi4-64-roix.conf` | Machine configuration for RPi4 64-bit |
| `recipes-core/images/roix-base.bb` | Base image recipe (SSH, networking, kernel modules) |

## Dependencies

| Layer | Repository |
|-------|------------|
| `meta` | poky |
| `meta-poky` | poky |
| `meta-yocto-bsp` | poky |
| `meta-raspberrypi` | meta-raspberrypi |
| `meta-oe` | meta-openembedded |
| `meta-python` | meta-openembedded |
| `meta-networking` | meta-openembedded |

## Image Features

- OpenSSH server (SSH + SFTP)
- systemd with networkd for DHCP on `eth0`
- I2C and SPI enabled
- UART console on `serial0` at 115200 baud
- Hostname: `roixpi`

## Compatibility

| Variable | Value |
|----------|-------|
| `LAYERSERIES_COMPAT` | scarthgap |
| `DISTRO_VERSION` | 1.0 |

## Usage

Add this layer to your `bblayers.conf`, set `MACHINE = "raspberrypi4-64-roix"` and `DISTRO = "roix"` in `local.conf`, then build:

```bash
bitbake roix-base
```