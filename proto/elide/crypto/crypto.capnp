@0x8affbcb9f0543e1b;

# Copyright © 2022, The Elide Framework Authors. All rights reserved.
#
# The Gust/Elide framework and tools, and all associated source or object computer code, except where otherwise noted,
# are licensed under the Zero Prosperity license, which is enclosed in this repository, in the file LICENSE.txt. Use of
# this code in object or source form requires and implies consent and agreement to that license in principle and
# practice. Source or object code not listing this header, or unless specified otherwise, remain the property of
# Elide LLC and its suppliers, if any. The intellectual and technical concepts contained herein are proprietary to
# Elide LLC and its suppliers and may be covered by U.S. and Foreign Patents, or patents in process, and are protected
# by trade secret and copyright law. Dissemination of this information, or reproduction of this material, in any form,
# is strictly forbidden except in adherence with assigned license requirements.

# Specifies core structures related to cryptographic operations and primitives. These records and enumerates are used
# throughout the codebase as a standard base set of definitions for hashing, encryption, and more.

using Java = import "/capnp/java.capnp";

$Java.package("elide.crypto");
$Java.outerClassname("Crypto");

# Specifies well-known hash algorithms.
enum HashAlgorithm {
  # No hash algorithm was/is active.
  identity @0;

  # Algorithm: MD5.
  md5 @1;

  # Algorithm: SHA1.
  sha1 @2;

  # Algorithm: SHA2.
  sha2 @3;

  # Algorithm: SHA-256.
  sha256 @4;

  # Algorithm: SHA-384.
  sha384 @5;

  # Algorithm: SHA-512.
  sha512 @6;

  # Algorithm: SHA3-224.
  sha3224 @7;

  # Algorithm: SHA3-256.
  sha3256 @8;

  # Algorithm: SHA3-512.
  sha3512 @9;
}
